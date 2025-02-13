package com.beauty1nside.hr.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.repository.query.Param;

import com.beauty1nside.hr.dto.EmployeeDTO;

@Mapper
public interface EmployeeMapper {
	// 전체 사원 조회
	List<EmployeeDTO> getAllEmployees();
	
	// 특정 사원 조회
	EmployeeDTO getEmployeeById(@Param("employeeNum") Long employeeNum);
	
	// 사원 추가
	void insertEmployee(EmployeeDTO employee);
	
	// 사원 정보 수정
	void updateEmployee(EmployeeDTO employee);
	
	// 사원 삭제
	void deleteEmployee(@Param("employeeNum") Long employeeNum);
}
