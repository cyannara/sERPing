package com.beauty1nside.hr.dto;

import lombok.Data;

@Data
public class EmpSearchDTO {
    private int start;      // 시작 페이지
    private int end;        // 끝 페이지
    private int pageUnit;   // 한페이지 보여줄 게시물수
   
    private String searchType;      // 검색 기준 (이름, 부서 등)
    private String searchKeyword;   // 검색어
    private String department;      // 부서
    private String position;        // 직급
    private String status;          // 재직 상태
    private String employmentType;  // 근무 유형
}
