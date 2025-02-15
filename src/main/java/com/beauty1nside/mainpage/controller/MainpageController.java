package com.beauty1nside.mainpage.controller;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Log4j2
@Controller
@AllArgsConstructor
@RequestMapping("/mainpage/*")
public class MainpageController {
  @GetMapping("/approval")
  public String mainpage() {
    return "mainpage";
  }
}
