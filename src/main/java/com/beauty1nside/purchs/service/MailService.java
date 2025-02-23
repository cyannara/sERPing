package com.beauty1nside.purchs.service;

/*import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import jakarta.mail.internet.MimeMessage;*/

//@Service
public class MailService {
	/*
	 * @Autowired private JavaMailSender mailSender;
	 * 
	 * public void sendMailWithAttachment( String fromEmail, String toEmail, String
	 * subject, String content, MultipartFile file ) throws Exception { // 1)
	 * MimeMessage 생성 MimeMessage message = mailSender.createMimeMessage();
	 * 
	 * // 2) multipart(true) 설정 MimeMessageHelper helper = new
	 * MimeMessageHelper(message, true, "UTF-8");
	 * 
	 * // 3) 메일 정보 설정 helper.setFrom(fromEmail); // Gmail은 spring.mail.username과
	 * 달라지면 OnBehalfOf로 표시될 수 있음 helper.setTo(toEmail); helper.setSubject(subject);
	 * helper.setText(content, true); // HTML 사용(true)
	 * 
	 * // 4) 첨부파일 처리 if (file != null && !file.isEmpty()) { String filename =
	 * file.getOriginalFilename(); byte[] fileBytes = file.getBytes();
	 * helper.addAttachment(filename, new ByteArrayResource(fileBytes)); }
	 * 
	 * // 5) 전송 mailSender.send(message); }
	 */
}
