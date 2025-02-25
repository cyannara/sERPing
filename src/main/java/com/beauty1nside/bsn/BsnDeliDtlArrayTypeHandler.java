package com.beauty1nside.bsn;

import java.sql.Array;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Struct;
import java.util.List;

import org.apache.ibatis.type.JdbcType;

import com.beauty1nside.bsn.dto.order.BsnOrderDetailDTO;

import oracle.jdbc.OracleConnection;

public class BsnDeliDtlArrayTypeHandler extends OrdDtlArrayTypeHandler{
	@Override
	public void setParameter(PreparedStatement ps, int i, Object parameter, JdbcType jdbcType) throws SQLException {
		if(parameter == null) return;
		
		OracleConnection conn = ps.getConnection().unwrap(OracleConnection.class); 
		List<BsnOrderDetailDTO> orderDetails = (List<BsnOrderDetailDTO>)parameter;
		
		//배열의 크기 지정 : 10
		Object[] filetype = new Object[10]; 
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
	    	filetype[8] = detail.getGoodsName();
	    	filetype[9] = detail.getOptionName();
	    	
	    	array[arrayIndex++] = conn.createStruct("BSN_ORD_DTL_FILETYPE", filetype);//FILETYPE은 Oracle에서 지정한 배열타입 이름 
	    }		
		Array filearray = (Array)conn.createOracleArray("BSN_ORD_DTLARRAY", (Struct[]) array);//FILEARRAY는 Oracle에서 지정한 배열타입 이름		
		ps.setArray(i, filearray);
	}
}
