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

import com.beauty1nside.bhf.dto.closing.BhfCloseDtlVO;

import oracle.jdbc.OracleConnection;

public class ClosingArrayStructHandler implements TypeHandler<Object> {

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
		
		List<BhfCloseDtlVO> files = (List<BhfCloseDtlVO>)parameter;
		
		Object[] closingFileType = new Object[5]; 
	    Struct[] closingArray = new Struct[files.size()];

	    int closingIndex = 0;
	    for (BhfCloseDtlVO file : files) {
	    	closingFileType[0] = file.getBnfSleQy();
	    	closingFileType[1] = file.getGoodsCode();
	    	closingFileType[2] = file.getGoodsName();
	    	closingFileType[3] = file.getOptionCode();
	    	closingFileType[4] = file.getOptionName();
	    	closingArray[closingIndex++] = conn.createStruct("CLOSINGFILETYPE", closingFileType);
	    }		
	    Array closingFileArray = (Array)conn.createOracleArray("CLOSINGFILEARRAY", (Struct[]) closingArray); 		
		ps.setArray(i, closingFileArray);
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
