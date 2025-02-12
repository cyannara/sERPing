package com.beauty1nside.hr.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.beauty1nside.hr.dto.EmployeeDTO;
import com.beauty1nside.hr.service.EmployeeService;

import groovy.util.logging.Log4j2;
import lombok.RequiredArgsConstructor;

@Log4j2
@RestController
@RequiredArgsConstructor
@RequestMapping("/hr/rest")
public class EmployeeController {
	private final EmployeeService employeeService;
	
	
	@GetMapping("list")
	public List<EmployeeDTO> getAllEmployees(){
		return employeeService.getAllEmployees();
	}
	
	
	@GetMapping("/{employeeNum}")
	public EmployeeDTO getEmployeeById(@PathVariable Long employeeNum) {
		return employeeService.getEmployeeById(employeeNum);
	}
	
    @PostMapping
    public ResponseEntity<String> insertEmployee(@RequestBody EmployeeDTO employee) {
        employeeService.insertEmployee(employee);
        return ResponseEntity.ok("사원 추가 완료");
    }

    @PutMapping
    public ResponseEntity<String> updateEmployee(@RequestBody EmployeeDTO employee) {
        employeeService.updateEmployee(employee);
        return ResponseEntity.ok("사원 정보 수정 완료");
    }

    @DeleteMapping("/{employeeNum}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long employeeNum) {
        employeeService.deleteEmployee(employeeNum);
        return ResponseEntity.ok("사원 삭제 완료");
    }


}
