package com.beauty1nside.mainpage;

import com.beauty1nside.security.service.CustomerUser;
import com.beauty1nside.security.util.SecurityUtil;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;

@Log4j2
@Controller
@AllArgsConstructor
public class MainpageController {
  @Autowired
  HttpSession session;
  
  @GetMapping("/")
  public String main() {
    CustomerUser userDetails = SecurityUtil.getCustomerUser(); // 공통 유틸리티 사용
    log.info("userDetails: {}", userDetails.getUserDTO().getDepartmentNum());
    log.info("session: {}", session.getAttribute("departmentNum"));
    
//    todo-dy
    // token 없으면 login 페이지로 이동하기
//    return "/login/login";
    // 있으면
    return "index";
  }
  
}
