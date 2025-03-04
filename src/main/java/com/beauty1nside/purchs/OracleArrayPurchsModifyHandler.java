package com.beauty1nside.purchs;

import java.math.BigDecimal;
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


import com.beauty1nside.purchs.dto.PurchUpdateDtlVO;

import oracle.jdbc.OracleConnection;

public class OracleArrayPurchsModifyHandler implements TypeHandler<Object> {
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
	    OracleConnection conn = ps.getConnection().unwrap(OracleConnection.class);
	    
	    // parameter가 null이면 명시적으로 null 설정
	    if (parameter == null) {
	        ps.setNull(i, java.sql.Types.ARRAY, "PURCHS_ORDER_MODIFY_FILE_ARRAY");
	        return;
	    }
	    
	    List<PurchUpdateDtlVO> files = (List<PurchUpdateDtlVO>) parameter;
	    
	    // 빈 리스트인 경우 빈 ARRAY 생성
	    if (files.isEmpty()) {
	        Array emptyArray = conn.createOracleArray("PURCHS_ORDER_MODIFY_FILE_ARRAY", new Struct[0]);
	        ps.setArray(i, emptyArray);
	        return;
	    }
	    
	    Struct[] array = new Struct[files.size()];
	    int arrayIndex = 0;
	    try {
	        for (PurchUpdateDtlVO file : files) {
	            Object[] filetype = new Object[8];
	            filetype[0] = new BigDecimal(file.getPurchaseBodyNum());
	            filetype[1] = new BigDecimal(file.getPurchaseQuantity());
	            filetype[2] = new BigDecimal(file.getPurchaseUnitPrice());
	            filetype[3] = new BigDecimal(file.getPurchaseSupplyPrice());
	            filetype[4] = new BigDecimal(file.getPurchaseVat());
	            filetype[5] = new BigDecimal(file.getOptionNum());
	            filetype[6] = file.getGoodsStandard();
	            filetype[7] = new BigDecimal(file.getCompanyNum());
	            // Oracle 내부 타입은 "PURCHS_ORDER_FILE_TYPE" (대문자, 언더바 포함)
	            array[arrayIndex++] = conn.createStruct("PURCHS_ORDER_MODIFY_FILE_TYPE", filetype);
	        }
	        // Oracle 내부 타입 배열 이름은 "PURCHS_ORDER_FILE_ARRAY"
	        Array filearray = conn.createOracleArray("PURCHS_ORDER_MODIFY_FILE_ARRAY", array);
	        ps.setArray(i, filearray);
	    } catch (SQLException e) {
	        e.printStackTrace();
	        throw new SQLException("PURCHS_ORDER_MODIFY_FILE_TYPE 변환 오류 발생", e);
	    }
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
