package com.beauty1nside.hr.controller;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.beauty1nside.hr.dto.DeptDTO;
import com.beauty1nside.hr.service.DeptService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@AllArgsConstructor
@RequestMapping("/hr/rest")
public class DeptRestController {
	final DeptService deptService;
	final PasswordEncoder passwordEncoder;
	
	// 부서 목록 조회
	@GetMapping("/dept/list")
    public List<DeptDTO> list(@RequestParam Long companyNum) {
        return deptService.list(companyNum);
    }
	
    // 회사 정보 조회
    @GetMapping("/companyInfo")
    public DeptDTO getCompanyInfo(@RequestParam Long companyNum) {
        return deptService.getCompanyInfo(companyNum);
    }

}
