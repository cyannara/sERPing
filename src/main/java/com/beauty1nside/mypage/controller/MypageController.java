package com.beauty1nside.mypage.controller;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Log4j2
@Controller
@AllArgsConstructor
@RequestMapping("/mypage")
public class MypageController {
  @GetMapping({"/", ""})
  public String mypage() {
    log.info("aaaa");
    return "mypage/mypage";
  }
}
