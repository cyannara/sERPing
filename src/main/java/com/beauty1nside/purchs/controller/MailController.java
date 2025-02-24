package com.beauty1nside.purchs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.beauty1nside.purchs.service.MailService;

@RestController
@RequestMapping("/mail")
public class MailController {
	@Autowired
    private MailService mailService;
	
	 @PostMapping("/send")
	    public ResponseEntity<String> sendMail(
	    		 @RequestParam("fromEmail") String fromEmail,
	             @RequestParam("toEmail") String toEmail,
	             @RequestParam("subject") String subject,
	             @RequestParam("content") String content,
	             @RequestParam(value = "file", required = false) MultipartFile file
	    ) {
	        try {
	        	// ✅ 수신자 이메일 유효성 검사
	            if (toEmail == null || toEmail.trim().isEmpty()) {
	                return ResponseEntity.badRequest().body("📌 오류: 메일 수신자가 없습니다.");
	            }

	            // ✅ 메일 전송 실행
	            mailService.sendMailWithAttachment(fromEmail, toEmail, subject, content, file);
	            return ResponseEntity.ok("✅ 메일 전송 성공!");
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	            return ResponseEntity.badRequest().body("메일 전송 실패: " + e.getMessage());
	        }
	    }
}
