package com.beauty1nside.mypage.controller;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Log4j2
@Controller
@AllArgsConstructor
@RequestMapping("/mypage")
public class MypageController {
  @GetMapping("/profile")
  public String mypage() {
    return "mypage/profile";
  }
  
  @GetMapping("/approval")
  public String approval() {
    return "mypage/myApproval";
  }
  
  @GetMapping("/approval/{documentId}")
  public String approvalWrite(@PathVariable(name="documentId") Long documentId, Model model) {
    model.addAttribute("documentId", documentId);
    return "mypage/approvalWrite";
  }
}
