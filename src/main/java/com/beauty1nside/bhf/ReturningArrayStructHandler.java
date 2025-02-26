package com.beauty1nside.bhf;

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

import com.beauty1nside.bhf.dto.returnInsert.BhfReturnInsertDtlVO;

import oracle.jdbc.OracleConnection;

public class ReturningArrayStructHandler implements TypeHandler<Object> {

	@Override
	public Object getResult(ResultSet rs, int columnIndex) throws SQLException {
		return null;
	}

	@Override
	public Object getResult(CallableStatement cs, int columnIndex) throws SQLException {
		return cs.getString(columnIndex);
	}

	@Override
	public void setParameter(PreparedStatement ps, int i, Object parameter,	JdbcType jdbcType) throws SQLException {
		if (parameter == null) return;
		
		OracleConnection conn = ps.getConnection().unwrap(OracleConnection.class); 
		
		List<BhfReturnInsertDtlVO> files = (List<BhfReturnInsertDtlVO>)parameter;
		
		Object[] returningFileType = new Object[9]; 
	    Struct[] returningArray = new Struct[files.size()];

	    int returningIndex = 0;
	    for (BhfReturnInsertDtlVO file : files) {
	    	returningFileType[0] = file.getGoodsCode();
	        returningFileType[1] = file.getGoodsName();
	        returningFileType[2] = file.getOptionCode();
	        returningFileType[3] = file.getOptionName();
	        returningFileType[4] = file.getQuantity();
	        returningFileType[5] = file.getExchangeReturningChoice(); 
	        returningFileType[6] = file.getReturningReason(); 
	        returningFileType[7] = file.getOptionBarcode();
	        returningFileType[8] = file.getGoodsLotNum();
	        returningArray[returningIndex++] = conn.createStruct("RETURNINGFILETYPE", returningFileType);
	    }		
	    Array returningFileArray = (Array)conn.createOracleArray("RETURNINGFILEARRAY", (Struct[]) returningArray); 		
		ps.setArray(i, returningFileArray);
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
