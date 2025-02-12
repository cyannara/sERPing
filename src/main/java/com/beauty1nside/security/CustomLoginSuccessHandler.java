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
    request.getSession().setAttribute("userid", userDTO.getId());
    request.getSession().setAttribute("deptName", userDTO.getDeptName());
    
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
      response.sendRedirect("/");
//    }
  }
}
