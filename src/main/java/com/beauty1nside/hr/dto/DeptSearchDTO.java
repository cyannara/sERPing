package com.beauty1nside.hr.dto;

import lombok.Data;

@Data
public class DeptSearchDTO {
    private int start;      // 시작 페이지
    private int end;        // 끝 페이지
    private int pageUnit;   // 한페이지 보여줄 게시물수
   
    private String deptSearchKeyword;   // 부서 검색어
    private String empSearchKeyword;   // 사원 검색어
    

}
