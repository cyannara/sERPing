package com.beauty1nside.hr.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beauty1nside.hr.dto.SalaryDTO;
import com.beauty1nside.hr.mapper.SalaryMapper;
import com.beauty1nside.hr.service.DeptService;
import com.beauty1nside.hr.service.SalaryService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service // ★이거 무조건 넣어!!
//@AllArgsConstructor	//모든필드를 생성자 초기화 한다
@RequiredArgsConstructor // 파이널 붙어 있는 필드만 초기화 해준다
//필드 하나뿐이면 그냥 all 하고 여러개이면 Required
public class SalaryServiceImpl implements SalaryService {

    @Autowired
    private SalaryMapper salaryMapper;

    // ✅ 특정 계약의 급여 정보 조회
    @Override
    public SalaryDTO getSalaryByContract(Long contractNum) {
        return salaryMapper.getSalaryByContract(contractNum);
    }

    // ✅ 급여 정보 업데이트 (공제 자동 반영)
    @Override
    public void updateSalary(SalaryDTO salary) {
        // 공제 계산
        double tax = salary.getBaseSalary() * 0.10; // 10% 세금
        double insurance = salary.getBaseSalary() * 0.09; // 9% 보험료
        double deduction = tax + insurance;
        double netSalary = (salary.getBaseSalary() + salary.getBonus()) - deduction;

        // 공제 반영 후 업데이트
        salary.setDeduction(deduction);
        salary.setNetSalary(netSalary);
        salaryMapper.updateSalary(salary);
    }

    // ✅ 신규 급여 등록
    @Override
    public void insertSalary(SalaryDTO salary) {
        salaryMapper.insertSalary(salary);
    }

    // ✅ 특정 사원의 급여 목록 조회
    @Override
    public List<SalaryDTO> getSalariesByEmployee(Long employeeNum) {
        return salaryMapper.getSalariesByEmployee(employeeNum);
    }

}
