package com.beauty1nside.bhf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2	//log4j 가 안되면 버전높은 log4j2 사용
@Controller
@AllArgsConstructor
@RequestMapping("/bhf/*")
public class BhfVueController {
	
	// 내 화면에서도 사이드바가 보이게 하는거
	@ModelAttribute
	  public void setAttributes(Model model) {
	    model.addAttribute("menu", "branch");
	  }

	//샘플 페이지
	@GetMapping("/")
	public String sample() {
		return "/bhf/sample";
	};

	// 상품 발주 요청 페이지
	@GetMapping("/order")
	public String order() {
		return "/bhf/orderRequest";
	};
	
	// 상품 발주 조회 페이지
	@GetMapping("/ordList")
	public String orderList() {
		return "/bhf/orderList";
	};
	
	// 교환 및 반품 요청 페이지
	@GetMapping("/return")
	public String returning() {
		return "/bhf/returnRequest";
	}
	
}
