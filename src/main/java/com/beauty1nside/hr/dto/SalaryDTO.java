package com.beauty1nside.hr.dto;

import java.util.Date;

import lombok.Data;

@Data
public class SalaryDTO {
    private Long salaryNum;       // 급여 번호 (PK)
    private Long employeeNum;     // 사원 번호 (FK)
    private Long contractNum;     // 계약 번호 (FK)
    private Double baseSalary;    // 기본 급여
    private Double bonus;         // 보너스
    private Double overtimePay;   // 연장 근무 수당
    private Double deduction;     // 공제 금액 (세금, 4대보험)
    private Double netSalary;     // 실지급 급여
    private Date paymentDate;     // 급여 지급일
    private Date registerDate;    // 등록일
    private Date updateDate;      // 수정일
    private Long companyNum;      // 회사 번호
}
