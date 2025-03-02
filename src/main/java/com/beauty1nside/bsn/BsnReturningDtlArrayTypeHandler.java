package com.beauty1nside.bsn;

import java.sql.Array;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Struct;
import java.util.List;

import org.apache.ibatis.type.JdbcType;

import com.beauty1nside.bsn.dto.cs.BsnReturningRegistDetailDTO;

import oracle.jdbc.OracleConnection;


public class BsnReturningDtlArrayTypeHandler extends OrdDtlArrayTypeHandler {
	@Override
	public void setParameter(PreparedStatement ps, int i, Object parameter, JdbcType jdbcType) throws SQLException {
		if(parameter == null) return;
		
		OracleConnection conn = ps.getConnection().unwrap(OracleConnection.class); 
		List<BsnReturningRegistDetailDTO> details = (List<BsnReturningRegistDetailDTO>)parameter;
		
		//배열의 크기 지정 : 12
		Object[] filetype = new Object[12]; 
	    Struct[] array = new Struct[details.size()];
		
	    int arrayIndex = 0;
	    for (BsnReturningRegistDetailDTO detail : details) {
	    	// 필드 추가
	    	filetype[0] = detail.getReturningDetailCode();
	    	filetype[1] = detail.getGoodsName();
	    	filetype[2] = detail.getGoodsCode();
	    	filetype[3] = detail.getOptionName();
	    	filetype[4] = detail.getOptionCode();
	    	filetype[5] = detail.getOptionBarcode();
	    	filetype[6] = detail.getExchangeReturningChoice();
	    	filetype[7] = detail.getReturningReason();
	    	filetype[8] = detail.getGoodsLotNum();
	    	filetype[9] = detail.getQuantity();
	    	filetype[10] = detail.getWarehousingQnt();
	    	filetype[11] = detail.getDisuseQnt();
	    	
	    	
	    	array[arrayIndex++] = conn.createStruct("BSN_CS_DTL_FILETYPE", filetype);//FILETYPE은 Oracle에서 지정한 배열타입 이름 
	    }		
		Array filearray = (Array)conn.createOracleArray("BSN_CS_DTLARRAY", (Struct[]) array);//FILEARRAY는 Oracle에서 지정한 배열타입 이름		
		ps.setArray(i, filearray);
	}

}
