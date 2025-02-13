package com.beauty1nside.security.service;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class UserDTO  {
//  private Long id;
//  private String loginId;
//  private String password;
//  private String fullName;
//  private String deptName;
//
//  private List<RoleDTO> roles;
  
  
  private Long employeeNum;
  private String employeeId;
  private String employeePw;
  private String employeeName;
  private String email;
  private String phone;
  private String position;
  private String authority;
  private List<RoleDTO> roles = new ArrayList<>();
  private Long companyNum;
  private String companyEngName;
  private Long departmentNum;
  
  public List<RoleDTO> getRoles() {
    if (roles == null) {
      roles = new ArrayList<>();
    }
    return roles;
  }
}
