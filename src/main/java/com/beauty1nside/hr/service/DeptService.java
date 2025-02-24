package com.beauty1nside.hr.service;

import java.util.List;
import java.util.Map;

import com.beauty1nside.hr.dto.DeptDTO;
import com.beauty1nside.hr.dto.EmpDTO;
import com.beauty1nside.hr.dto.EmpSearchDTO;


public interface DeptService {
	
    // 부서 목록 조회
    List<DeptDTO> list(Long companyNum);

    // 회사 정보 조회
    DeptDTO getCompanyInfo(Long companyNum);
    
    Map<String, Object> getOrganization(Long companyNum);
    
    // 부서 추가
    void insertDepartment(DeptDTO dto);

}