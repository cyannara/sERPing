package com.beauty1nside.hr.service;

import java.util.List;

import com.beauty1nside.hr.dto.EmployeeDTO;


public interface EmployeeService {
    List<EmployeeDTO> getAllEmployees();
    EmployeeDTO getEmployeeById(Long employeeNum);
    void insertEmployee(EmployeeDTO employee);
    void updateEmployee(EmployeeDTO employee);
    void deleteEmployee(Long employeeNum);
}