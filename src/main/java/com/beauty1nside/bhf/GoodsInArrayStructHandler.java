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

import com.beauty1nside.bhf.dto.goodsin.BhfGoodsInDtlVO;

import oracle.jdbc.OracleConnection;

public class GoodsInArrayStructHandler implements TypeHandler<Object> {

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
		
		List<BhfGoodsInDtlVO> files = (List<BhfGoodsInDtlVO>)parameter;
		
		Object[] goodsInFileType = new Object[12]; 
	    Struct[] goodsInArray = new Struct[files.size()];

	    int goodsInIndex = 0;
	    for (BhfGoodsInDtlVO file : files) {
	    	goodsInFileType[0] = file.getBranchOfficeId();
	    	goodsInFileType[1] = file.getGoodsCode();
	    	goodsInFileType[2] = file.getGoodsName();
	    	goodsInFileType[3] = file.getOptionCode();
	    	goodsInFileType[4] = file.getOptionName();
	    	goodsInFileType[6] = file.getGoodsStandard(); 
	    	goodsInFileType[5] = file.getQuantity(); 
	    	goodsInFileType[7] = file.getStockQuantity();
	    	goodsInFileType[8] = file.getInQuantity();
	    	goodsInFileType[9] = file.getCompanyNum();
	    	goodsInFileType[10] = file.getReorder();
	    	goodsInFileType[11] = file.getReturnNum();
	        goodsInArray[goodsInIndex++] = conn.createStruct("GOODSINFILETYPE", goodsInFileType);
	    }		
	    Array goodsInFileArray = (Array)conn.createOracleArray("GOODSINFILEARRAY", (Struct[]) goodsInArray); 		
		ps.setArray(i, goodsInFileArray);
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
