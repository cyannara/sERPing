package com.beauty1nside.hr.service;

import java.util.List;

import com.beauty1nside.hr.dto.SalaryDTO;

public interface SalaryService {

    // ✅ 특정 계약의 급여 정보 조회
    SalaryDTO getSalaryByContract(Long contractNum);

    // ✅ 급여 정보 업데이트 (공제 계산 후 저장)
    void updateSalary(SalaryDTO salary);

    // ✅ 신규 급여 등록
    void insertSalary(SalaryDTO salary);

    // ✅ 특정 사원의 급여 목록 조회
    List<SalaryDTO> getSalariesByEmployee(Long employeeNum);
}
