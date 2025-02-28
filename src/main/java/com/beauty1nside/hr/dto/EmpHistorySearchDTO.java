package com.beauty1nside.hr.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
public class EmpHistorySearchDTO {
    private int start;      // 시작 페이지
    private int end;        // 끝 페이지
    private int pageUnit;   // 한 페이지당 게시물 수

    private Long employeeNum;      // 특정 사원의 발령 이력 조회
    private Long companyNum;       // 소속 회사 (세션에서 가져온 값)
    private String approvalStatus; // 승인 상태 (대기, 승인, 반려)
    private Long processedBy;      // 처리자 (발령 승인자)
    private String changeType;     // 발령 유형 (승진, 부서이동 등)
    private Date effectiveDateFrom; // 적용일 검색 (시작)
    private Date effectiveDateTo;   // 적용일 검색 (끝)
}
