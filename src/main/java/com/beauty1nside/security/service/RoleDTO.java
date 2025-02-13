package com.beauty1nside.security.service;

import lombok.Data;

@Data
public class RoleDTO {
  private String userId;
  private String roleName;
  
//  private String cmmnCode;
//  private String cmmnName;
  
  //  AU001	최고관리자	회사 전반적인 데이터 관리 및 운영 가능 (ERP 구독사 대표자)
  //  AU002	관리자	    부서 내 최고 관리자 (부서 단위 데이터 관리)
  //  AU003	지점장	    지점 내 데이터 및 소속 직원 관리 가능
  //  AU004	사원	      기본 기능 사용 가능
}
