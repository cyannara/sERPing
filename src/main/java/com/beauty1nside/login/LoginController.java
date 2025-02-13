package com.beauty1nside.login;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Log4j2  //log4j 가 안되면 버전높은 log4j2 사용
@Controller
@AllArgsConstructor
public class LoginController {
  @GetMapping("/login")
  public String login() {
    return "/login/login";
  }
  
  @PostMapping("/login")
  public String login(@RequestParam String employeeId, @RequestParam String employeePw) {
    System.out.println("입력된 employeeId: " + employeeId);
    System.out.println("입력된 employeePw: " + employeePw);
    return "redirect:/home";
  }
  
}
