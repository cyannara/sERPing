package com.beauty1nside.bsn;

import java.sql.Array;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Struct;
import java.util.List;

import org.apache.ibatis.type.JdbcType;

import com.beauty1nside.bsn.dto.delivery.BsnDeliveryLotDTO;

import oracle.jdbc.OracleConnection;

public class BsnDeliDtlArrayTypeHandler extends OrdDtlArrayTypeHandler{
	@Override
	public void setParameter(PreparedStatement ps, int i, Object parameter, JdbcType jdbcType) throws SQLException {
		if(parameter == null) return;
		
		OracleConnection conn = ps.getConnection().unwrap(OracleConnection.class); 
		List<BsnDeliveryLotDTO> lotDetails = (List<BsnDeliveryLotDTO>)parameter;
		
		//배열의 크기 지정 : 5
		Object[] filetype = new Object[5]; 
	    Struct[] array = new Struct[lotDetails.size()];
		
	    int arrayIndex = 0;
	    for (BsnDeliveryLotDTO detail : lotDetails) {
	    	filetype[0] = detail.getDeliveryLotDetailNum();
	    	filetype[1] = detail.getDeliveryDetailId();
	    	filetype[2] = detail.getGoodsLotNum();
	    	filetype[3] = detail.getDeliveryPossibleQnt();
	    	filetype[4] = detail.getDeliveryQnt();
	    	
	    	
	    	array[arrayIndex++] = conn.createStruct("BSN_DLV_LOT_DTL_FILETYPE", filetype);//FILETYPE은 Oracle에서 지정한 배열타입 이름 
	    }		
		Array filearray = (Array)conn.createOracleArray("BSN_DLV_LOT_DTLArray", (Struct[]) array);//FILEARRAY는 Oracle에서 지정한 배열타입 이름		
		ps.setArray(i, filearray);
	}
}
