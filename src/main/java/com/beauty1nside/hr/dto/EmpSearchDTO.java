package com.beauty1nside.hr.dto;

import lombok.Data;

@Data
public class EmpSearchDTO {
    private int start;      // 시작 페이지
    private int end;        // 끝 페이지
    private int pageUnit;   // 한페이지 보여줄 게시물수
   
    private String searchType;      // 검색 기준 (이름, 부서 등)
    private String searchKeyword;   // 검색어
    private String departmentNum;      // 부서번호
    private String subDepartmentNum;
    private String departmentName;  // 부서명
    private String position;        // 직급
    private String status;          // 재직 상태
    private String employmentType;  // 근무 유형
    
    public void setDepartmentNum(String departmentNum) {
        this.departmentNum = (departmentNum != null && !departmentNum.isEmpty()) ? departmentNum : null;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = (departmentName != null && !departmentName.isEmpty()) ? departmentName : null;
    }
    
}
