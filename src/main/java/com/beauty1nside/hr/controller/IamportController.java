package com.beauty1nside.hr.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.beauty1nside.hr.service.IamportService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/iamport")
public class IamportController {
    
    private final IamportService iamportService;

    /**
     * ✅ 1. Access Token 요청
     */
    @GetMapping("/token")
    public ResponseEntity<String> getIamportToken() {
        log.info("Access Token 요청 시작");
        String accessToken = iamportService.getAccessToken();
        log.info("Access Token 발급 완료: {}", accessToken);
        return ResponseEntity.ok(accessToken);
    }
    
    /**
     * ✅ 2. 계좌 실명 조회 API
     */
    @GetMapping("/account-holder")
    public ResponseEntity<String> getAccountHolder(
            @RequestParam String bankCode,
            @RequestParam String accountNumber) {
        
        log.info("예금주 조회 요청 - 은행코드: {}, 계좌번호: {}", bankCode, accountNumber);
        String accountHolder = iamportService.getAccountHolder(bankCode, accountNumber);
        log.info("조회된 예금주: {}", accountHolder);
        return ResponseEntity.ok(accountHolder);
    }    
}
