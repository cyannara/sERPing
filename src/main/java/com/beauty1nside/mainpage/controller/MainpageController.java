package com.beauty1nside.mainpage.controller;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Log4j2
@Controller
@AllArgsConstructor
@RequestMapping("/mainpage/*")
public class MainpageController {
  @GetMapping("/approval")
  public String mainpage(@RequestParam("inApprovalId") Long inApprovalId,
                         Model model) {
    model.addAttribute("inApprovalId", inApprovalId);
    return "mainpage/mainpage";
  }
}
