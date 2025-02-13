package com.beauty1nside.hr.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.beauty1nside.hr.dto.EmployeeDTO;
import com.beauty1nside.hr.mapper.EmployeeMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeService {
	private final EmployeeMapper employeeMapper;
	
	public List<EmployeeDTO> getAllEmployees(){
		return employeeMapper.getAllEmployees();
	}
	
	public EmployeeDTO getEmployeeById(Long employeeNum) {
		return employeeMapper.getEmployeeById(employeeNum);
	}
	
    public void insertEmployee(EmployeeDTO employee) {
        employeeMapper.insertEmployee(employee);
    }
	
	public void updateEmployee(EmployeeDTO employee) {
		employeeMapper.updateEmployee(employee);
	}
	
	public void deleteEmployee(Long employeeNum) {
		employeeMapper.deleteEmployee(employeeNum);
	}
	
	
}
