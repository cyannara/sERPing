package com.beauty1nside.bsn;

import java.sql.Array;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Struct;
import java.util.List;
import oracle.jdbc.OracleConnection;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;
import org.springframework.util.StringUtils;


import com.beauty1nside.bsn.dto.BsnOrderDetailDTO;

public class OrdDtlArrayTypeHandler implements TypeHandler<Object> {

	@Override
	public void setParameter(PreparedStatement ps, int i, Object parameter, JdbcType jdbcType) throws SQLException {
		if(parameter == null) return;
		
		OracleConnection conn = ps.getConnection().unwrap(OracleConnection.class); 
		List<BsnOrderDetailDTO> orderDetails = (List<BsnOrderDetailDTO>)parameter;
		
		//배열의 크기 지정 : 8
		Object[] filetype = new Object[8]; 
	    Struct[] array = new Struct[orderDetails.size()];
		
	    int arrayIndex = 0;
	    for (BsnOrderDetailDTO detail : orderDetails) {
	    	filetype[0] = detail.getOrderDetailId();
	    	filetype[1] = detail.getOrderId();
	    	filetype[2] = detail.getGoodsCode();
	    	filetype[3] = detail.getOptionCode();
	    	filetype[4] = detail.getQuantity();
	    	filetype[5] = detail.getGoodsStandard();
	    	filetype[6] = detail.getUnitPrice();
	    	filetype[7] = detail.getSummationAmt();
	    	
	    	array[arrayIndex++] = conn.createStruct("BSN_ORD_DTL_FILETYPE", filetype);//FILETYPE은 Oracle에서 지정한 배열타입 이름 
	    }		
		Array filearray = (Array)conn.createOracleArray("BSN_ORD_DTLARRAY", (Struct[]) array);//FILEARRAY는 Oracle에서 지정한 배열타입 이름		
		ps.setArray(i, filearray);
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

	@Override
	public Object getResult(ResultSet rs, int columnIndex) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getResult(CallableStatement cs, int columnIndex) throws SQLException {
		return cs.getString(columnIndex);
	}

}
