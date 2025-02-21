package com.beauty1nside.mypage.controller;

import com.beauty1nside.mainpage.dto.ApprovalDTO;
import com.beauty1nside.mainpage.service.ApprovalService;
import com.beauty1nside.security.service.CustomerUser;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Log4j2
@RestController
@AllArgsConstructor
@RequestMapping("/api/mypage/*")
public class MypageRestController {
  final ApprovalService approvalService;
  
  @PostMapping("/approval")
  public ResponseEntity<Map<String, Object>> submitApproval(@RequestBody ApprovalDTO dto,
                                                            @AuthenticationPrincipal CustomerUser user) {
    Map<String, Object> response = new HashMap<>();
    try {
      // 결재서 등록 todo-dy
      
      response.put("message", "success");
      return ResponseEntity.ok(response);
    } catch (Exception e) {
      response.put("message", "fail");
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }
    
  }

}
