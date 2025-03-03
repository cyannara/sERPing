package com.beauty1nside.hr.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EmpHistoryDTO {
    private Long historyNum;          // 발령 이력 번호 (PK, SEQ 사용)
    private Long employeeNum;         // 대상 사원 번호
    private Long companyNum;          // 소속 회사 번호
    private String changeType;        // 변경 유형 (승진, 부서이동 등)
    private String previousPosition;  // 기존 직급
    private String newPosition;       // 새로운 직급
    private Long previousDepartmentNum; // 기존 부서 번호
    private Long previousDepartmentName; // 기존 부서 번호
    private Long newDepartmentName;    // 새로운 부서 번호
    private String previousEmploymentType; // 기존 고용 유형
    private String newEmploymentType; // 새로운 고용 유형
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date effectiveDate;  // 적용일 (직접 입력)
    private Long processedBy;         // 발령 승인자 (권한 있는 관리자)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date registerDate;   // 등록일 (기본값 SYSDATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date updateDate;     // 최종 수정일
    private String approvalStatus;    // 승인 상태 (AP001: 대기, AP002: 승인, AP003: 반려)
    private String rejectReason;      // 반려 사유 (반려 시 입력)

}
