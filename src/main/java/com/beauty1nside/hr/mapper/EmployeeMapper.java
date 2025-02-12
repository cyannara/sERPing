package com.beauty1nside.hr.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.beauty1nside.hr.dto.EmployeeDTO;

@Mapper
public interface EmployeeMapper {
	List<EmployeeDTO> getAllEmployees();
	EmployeeDTO getEmployeeById(Long employeeNum);
	void insertEmployee(EmployeeDTO employee);
	void updateEmployee(EmployeeDTO employee);
	void deleteEmployee(Long employeeNum);
}
