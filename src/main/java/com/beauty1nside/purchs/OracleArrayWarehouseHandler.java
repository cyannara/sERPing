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

import com.beauty1nside.purchs.dto.ProdInsertDtlVO;
import com.beauty1nside.purchs.dto.PurchInsertDtlVO;
import com.beauty1nside.purchs.dto.PurchInsertVO;
import com.beauty1nside.purchs.dto.WarehouseInsertDtlVO;

import oracle.jdbc.OracleConnection;

public class OracleArrayWarehouseHandler implements TypeHandler<Object> {
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
	        ps.setNull(i, java.sql.Types.ARRAY, "purchs_warehouse_file_array");
	        return;
	    }
	    
	    List<WarehouseInsertDtlVO> files = (List<WarehouseInsertDtlVO>) parameter;
	    
	    // 빈 리스트인 경우 빈 ARRAY 생성
	    if (files.isEmpty()) {
	        Array emptyArray = conn.createOracleArray("purchs_warehouse_file_array", new Struct[0]);
	        ps.setArray(i, emptyArray);
	        return;
	    }
	    
	    Struct[] array = new Struct[files.size()];
	    int arrayIndex = 0;
	    try {
	        for (WarehouseInsertDtlVO file : files) {
	            Object[] filetype = new Object[9];
	            filetype[0] = file.getGoodsStandard();
	            filetype[1] = new BigDecimal(file.getWarehouseId());
	            filetype[2] = new BigDecimal(file.getWarehousingStandardQuantity());
	            filetype[3] = new BigDecimal(file.getWarehousingUnitPrice());
	            filetype[4] = new BigDecimal(file.getWarehousingSupplyPrice());
	            filetype[5] = new BigDecimal(file.getWarehousingVat());
	            filetype[6] = new BigDecimal(file.getOptionNum());
	            filetype[7] = new BigDecimal(file.getPurchaseBodyNum());// null이면 그대로 null 전송
	            filetype[7] = file.getManufactureDate();
	            // Oracle 내부 타입은 "PURCHS_ORDER_FILE_TYPE" (대문자, 언더바 포함)
	            array[arrayIndex++] = conn.createStruct("purchs_warehouse_file_type", filetype);
	        }
	        // Oracle 내부 타입 배열 이름은 "PURCHS_ORDER_FILE_ARRAY"
	        Array filearray = conn.createOracleArray("purchs_warehouse_file_Array", array);
	        ps.setArray(i, filearray);
	    } catch (SQLException e) {
	        e.printStackTrace();
	        throw new SQLException("purchs_warehouse_file_type 변환 오류 발생", e);
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
