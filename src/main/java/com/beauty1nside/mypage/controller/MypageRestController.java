package com.beauty1nside.mypage.controller;

import com.beauty1nside.mainpage.service.ApprovalService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@AllArgsConstructor
@RequestMapping("/api/mypage/*")
public class MypageRestController {
  final ApprovalService approvalService;
}
