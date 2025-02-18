package com.beauty1nside.purchs;

import java.sql.Array;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Struct;
import java.util.List;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;
import org.springframework.util.StringUtils;

import com.beauty1nside.purchs.dto.ProdInsertDtlVO;

import oracle.jdbc.driver.OracleConnection;

public class OracleArrayProductHandler implements TypeHandler<Object> {
	@Override
	public Object getResult(ResultSet rs, int columnIndex) throws SQLException {
		return null;
	}
	
	@Override
	public Object getResult(CallableStatement cs, int columnIndex) throws SQLException {
		return cs.getString(columnIndex);
	}

	//여러 값 보내는 옵션의 컬럼 갯수 지정 
	@Override
	public void setParameter(PreparedStatement ps, int i, Object parameter, JdbcType jdbcType) throws SQLException {
		if(parameter == null)
			return;
		OracleConnection conn= ps.getConnection().unwrap(OracleConnection.class);
		List<ProdInsertDtlVO> files = (List<ProdInsertDtlVO>)parameter;
		
		//배열 크기 2로 지정 
		Object[] filetype = new Object[2];
		Struct[] array= new Struct[files.size()];
		
		int arrayIndex = 0;
		for (ProdInsertDtlVO file : files) {
			filetype[0] = file.getOptionName();
			filetype[1] = file.getWarehouseId();
			
			array[arrayIndex++] = conn.createStruct("PURCHSFILETYPE", filetype); //PURCHSFILETYPE은 Oracle에서 지정한 배열타입 이름 
		}
		Array filearray = (Array)conn.createStruct("PURCHSFILETYPE", (Struct[]) array); //PURCHSFILETYPE은 Oracle에서 지정한 배열타입 이름 
	}
	
	@Override
	public Object getResult(ResultSet rs, String columnName) throws SQLException {

		String value = "";
		try {
			if (!StringUtils.hasText(rs.getString(columnName))) {
				value = new String(rs.getString(columnName).getBytes("8859_1"), "KSC5601");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;

	}

	

	

}
