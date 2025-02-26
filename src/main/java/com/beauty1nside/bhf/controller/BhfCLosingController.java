package com.beauty1nside.bhf.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.beauty1nside.bhf.dto.closing.BhfCloseVO;
import com.beauty1nside.bhf.service.BhfClosingService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2	//log4j 가 안되면 버전높은 log4j2 사용
@RestController
@AllArgsConstructor
@RequestMapping("/bhf/rest/*")
public class BhfCLosingController {
	
	BhfClosingService service;
	
	// 교환및반품 등록
	@PostMapping("/close/insert")
	public ResponseEntity<Map<String, Object>> reinsert(@RequestBody BhfCloseVO vo) {
	    Map<String, Object> response = new HashMap<>();
	    try {
	    	service.bhf_close(vo);
	        response.put("status", "success");
	        response.put("message", "마감정산 등록 성공");
	        return ResponseEntity.ok(response); // JSON 형태 응답
	    } catch (Exception e) {
	        log.error("교환 및 반품 등록 실패", e);
	        response.put("status", "error");
	        response.put("message", "마감정산 등록 실패");
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
	    }
	}

}
