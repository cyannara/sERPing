package com.beauty1nside.hr.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.beauty1nside.hr.dto.SalaryDTO;
import com.beauty1nside.hr.service.SalaryService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@AllArgsConstructor
@RequestMapping("/hr/rest")
public class SalaryRestController {
	final SalaryService salaryService;
	
	// ✅ 특정 계약의 급여 정보 조회
    @GetMapping("/{contractNum}")
    public SalaryDTO getSalary(@PathVariable Long contractNum) {
        return salaryService.getSalaryByContract(contractNum);
    }

    // ✅ 급여 정보 업데이트
    @PutMapping("/update")
    public void updateSalary(@RequestBody SalaryDTO salary) {
        salaryService.updateSalary(salary);
    }
}
