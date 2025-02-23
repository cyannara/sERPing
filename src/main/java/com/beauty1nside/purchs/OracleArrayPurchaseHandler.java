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

import oracle.jdbc.OracleConnection;

public class OracleArrayPurchaseHandler implements TypeHandler<Object> {
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
	        ps.setNull(i, java.sql.Types.ARRAY, "PURCHS_ORDER_FILE_ARRAY");
	        return;
	    }
	    
	    List<PurchInsertDtlVO> files = (List<PurchInsertDtlVO>) parameter;
	    
	    // 빈 리스트인 경우 빈 ARRAY 생성
	    if (files.isEmpty()) {
	        Array emptyArray = conn.createOracleArray("PURCHS_ORDER_FILE_ARRAY", new Struct[0]);
	        ps.setArray(i, emptyArray);
	        return;
	    }
	    
	    Struct[] array = new Struct[files.size()];
	    int arrayIndex = 0;
	    try {
	        for (PurchInsertDtlVO file : files) {
	            Object[] filetype = new Object[8];
	            filetype[0] = new BigDecimal(file.getCompanyNum());
	            filetype[1] = file.getGoodsStandard();
	            filetype[2] = new BigDecimal(file.getOptionNum());
	            filetype[3] = file.getOrderPlanBodyNum();  // null이면 그대로 null 전송
	            filetype[4] = new BigDecimal(file.getPurchaseQuantity());
	            filetype[5] = new BigDecimal(file.getPurchaseSupplyPrice());
	            filetype[6] = new BigDecimal(file.getPurchaseUnitPrice());
	            filetype[7] = new BigDecimal(file.getPurchaseVat());
	            // Oracle 내부 타입은 "PURCHS_ORDER_FILE_TYPE" (대문자, 언더바 포함)
	            array[arrayIndex++] = conn.createStruct("PURCHS_ORDER_FILE_TYPE", filetype);
	        }
	        // Oracle 내부 타입 배열 이름은 "PURCHS_ORDER_FILE_ARRAY"
	        Array filearray = conn.createOracleArray("PURCHS_ORDER_FILE_ARRAY", array);
	        ps.setArray(i, filearray);
	    } catch (SQLException e) {
	        e.printStackTrace();
	        throw new SQLException("PURCHS_ORDER_FILE_TYPE 변환 오류 발생", e);
	    }
	}


	
//	@Override
//	public void setParameter(PreparedStatement ps, int i, Object parameter, JdbcType jdbcType) throws SQLException {
//	    if (parameter == null) {
//	        ps.setNull(i, Types.ARRAY);
//	        return;
//	    }
//
//	    Connection conn = ps.getConnection();
//
//	    // ✅ HikariCP 환경에서도 정상적으로 OracleConnection을 가져오도록 처리
//	    OracleConnection oracleConn;
//	    if (conn.isWrapperFor(OracleConnection.class)) {
//	        oracleConn = conn.unwrap(OracleConnection.class);
//	    } else {
//	        throw new SQLException("OracleConnection으로 변환할 수 없습니다.");
//	    }
//
//	    List<ProdInsertDtlVO> files = (List<ProdInsertDtlVO>) parameter;
//	    Struct[] structArray = new Struct[files.size()];
//
//	    for (int j = 0; j < files.size(); j++) {
//	        Object[] fileData = { files.get(j).getOptionName(), files.get(j).getWarehouseId() };
//	        structArray[j] = oracleConn.createStruct("PURCHSFILETYPE", fileData);
//	    }
//
//	    // ✅ `createOracleArray` 사용
//	    Array oracleArray = oracleConn.createOracleArray("PURCHSFILEARRAY", structArray);
//	    ps.setArray(i, oracleArray);
//	}


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
