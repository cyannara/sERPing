package com.beauty1nside.purchs;

import java.sql.Array;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Struct;
import java.sql.Types;
import java.util.List;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;
import org.springframework.util.StringUtils;

import com.beauty1nside.purchs.dto.ProdInsertDtlVO;

import oracle.jdbc.driver.OracleConnection;

public class OracleArrayProductHandler implements TypeHandler<Object> {
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
	    if (parameter == null) return;

	    Connection connection = ps.getConnection();
	    OracleConnection conn;
	    if (connection.isWrapperFor(OracleConnection.class)) {
	        conn = connection.unwrap(OracleConnection.class);
	    } else {
	        throw new SQLException("OracleConnection으로 unwrap 할 수 없습니다.");
	    }

	    List<ProdInsertDtlVO> files = (List<ProdInsertDtlVO>) parameter;

	   
	    Struct[] array = new Struct[files.size()];
	    Object[] filetype = new Object[2];
	    
	    int arrayIndex = 0;
	    for (ProdInsertDtlVO file : files) {
	    	
	        filetype[0] = file.getOptionName();
	        filetype[1] = file.getWarehouseId();

	        try {
	            array[arrayIndex++] = conn.createStruct("PURCHSFILETYPE", filetype);
	        } catch (SQLException e) {
	            e.printStackTrace(); // 🔥 오류 로그 출력
	            throw new SQLException("PURCHSFILETYPE 변환 오류 발생", e);
	        }
	    }

	    try {
	        Array filearray = conn.createOracleArray("PURCHSFILEARRAY", array);
	        ps.setArray(i, filearray);
	    } catch (SQLException e) {
	        e.printStackTrace(); // 🔥 오류 로그 출력
	        throw new SQLException("PURCHSFILEARRAY 변환 오류 발생", e);
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
