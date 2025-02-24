package com.beauty1nside.hr.dto;

import java.util.Date;

import lombok.Data;

@Data
public class EmpContractDTO {

    private Long contractNum;      // 계약 번호 (PK)
    private String contractType;   // 계약 유형 (정규직, 계약직 등)
    private Date contractStartDate; // 계약 시작일
    private Date contractEndDate;   // 계약 종료일 (없으면 무기 계약)
    private Double salary;          // 기본 급여
    private String workStartTime;   // 근무 시작 시간 (09:00 등)
    private String workEndTime;     // 근무 종료 시간 (18:00 등)
    private Double workHours;       // 근무 시간 (8.0시간 등)
    private int probationPeriod;    // 수습 기간 (개월)
    private String contractStatus;  // 계약 상태 (CS001: 진행중, CS002: 만료 등)
    private String terminationReason; // 계약 해지 사유
    private String contractFilePath; // 계약서 파일 경로
    private Long departmentNum;      // 부서 번호
    private String position;         // 직급 (PO001 등)
    private Date registerDate;       // 등록일
    private Date updateDate;         // 수정일
    private Long companyNum;         // 회사 번호
    private Long employeeNum;        // 사원 번호
	
}
