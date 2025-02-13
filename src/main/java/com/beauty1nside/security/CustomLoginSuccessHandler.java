package com.beauty1nside.security;

import com.beauty1nside.security.service.CustomerUser;
import com.beauty1nside.security.service.UserDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler {
  
  
  @Override
  public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
    UserDTO userDTO = ((CustomerUser) authentication.getPrincipal()).getUserDTO();
    
    //session
    request.getSession().setAttribute("employeeNum", userDTO.getEmployeeNum());
    request.getSession().setAttribute("employeeId", userDTO.getEmployeeId());
    request.getSession().setAttribute("employeeName", userDTO.getEmployeeName());
    request.getSession().setAttribute("email", userDTO.getEmail());
    request.getSession().setAttribute("phone", userDTO.getPhone());
    request.getSession().setAttribute("position", userDTO.getPosition());
    request.getSession().setAttribute("authority", userDTO.getAuthority());
    request.getSession().setAttribute("roles", userDTO.getRoles());
    request.getSession().setAttribute("companyNum", userDTO.getCompanyNum());
    request.getSession().setAttribute("companyEngName", userDTO.getCompanyEngName());
    request.getSession().setAttribute("departmentNum", userDTO.getDepartmentNum());
    
    // user한명이 롤 여러개 가지고 있을 수 있으니까
    List<String> roleNames = new ArrayList<>();
    authentication.getAuthorities().forEach(authority -> {
      roleNames.add(authority.getAuthority());
    });
    
    System.out.println("roleNames = " + roleNames);
    
//    if(roleNames.contains("ROLE_ADMIN")) {
//      response.sendRedirect("/admin");
//    } else if(roleNames.contains("ROLE_USER")){
//      response.sendRedirect("/hello");
//    } else {
    // 이전 페이지 정보 삭제
//    request.getSession().removeAttribute("SPRING_SECURITY_SAVED_REQUEST");
      response.sendRedirect("/");
//    }
  }
}
