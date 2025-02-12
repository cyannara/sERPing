package com.beauty1nside.mainpage;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Log4j2
@Controller
@AllArgsConstructor
public class MainpageController {
  @GetMapping("/")
  public String main() {
//    todo-dy
    // token 없으면 login 페이지로 이동하기
//    return "/login/login";
    // 있으면
    return "/index.html";
  }
  
}
