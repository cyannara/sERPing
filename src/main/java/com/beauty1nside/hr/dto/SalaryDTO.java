package com.beauty1nside.hr.dto;

import java.util.Date;

import org.apache.ibatis.type.Alias;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Alias("SalaryDTO")  // MyBatis 별칭
public class SalaryDTO {
    
    private Long salaryNum; // 급여번호 (PK)
    private Long employeeNum; // 사원번호 (FK)
    private Long contractNum; // 계약번호 (FK)
    private Long companyNum;  // 회사번호 (FK)
    
    private Double monthlySalary; // 월 기본급
    private Double bonus; // 상여금
    private Double additionalPay; // 추가 수당
    private Double overtimePay; // 연장 근로 수당
    
    private Double deduction; // 공제액 (세금 + 보험료)
    private Double netSalary; // 실수령액 (월급 - 공제액)

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date salaryPaymentDate; // 급여 지급일
    
    private String paymentMethod; // 지급 방식 (BANK or CASH)
    
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date paymentDate; // 실제 급여 지급일

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date registerDate; // 등록일

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateDate; // 수정일
}
