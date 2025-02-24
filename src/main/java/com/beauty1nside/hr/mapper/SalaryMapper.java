package com.beauty1nside.hr.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.beauty1nside.hr.dto.SalaryDTO;

@Mapper
public interface SalaryMapper {
    
    // ✅ 특정 계약의 급여 조회
    SalaryDTO getSalaryByContract(Long contractNum);

    // ✅ 급여 정보 업데이트 (공제 자동 반영)
    void updateSalary(SalaryDTO salary);

    // ✅ 급여 등록 (계약 등록 시 함께 저장)
    void insertSalary(SalaryDTO salary);

    // ✅ 특정 사원의 급여 목록 조회
    List<SalaryDTO> getSalariesByEmployee(Long employeeNum);
    
}
