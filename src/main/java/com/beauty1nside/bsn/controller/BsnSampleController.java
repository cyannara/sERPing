package com.beauty1nside.bsn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.beauty1nside.bsn.dto.OrderSearchDTO;
import com.beauty1nside.bsn.service.BsnOrderService;
import com.beauty1nside.common.Paging;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2	//log4j 가 안되면 버전높은 log4j2 사용

@Controller
@AllArgsConstructor
@RequestMapping("/bsn/*")
public class BsnSampleController {
	
	//final private BsnOrderService bsnOrderService;

	//샘플 페이지
	@GetMapping("/")
	public String sample() {
		return "redirect:/bsn/order";
	};
	
	@GetMapping("/test")
	public String test() {
		return "/bsn/sample";
	};
	
	@GetMapping("/test2")
	public String test2() {
		return "/bsn/sample2";
	};
	
	
	@GetMapping("/test3")
	public String test3() {
		return "/bsn/testOrder";
	};
	
	
	@GetMapping("/order")
	public String order() {
		return "redirect:/bsn/orderRegist";
	};
	
	
	@GetMapping("/order/Regist")
	public String orderRegist() {
		

		return "/bsn/orderRegist";
	};
	
	@GetMapping("/order/List")
	public String orderList() {
		
		return "/bsn/orderList";
	};
	
	
	
	@GetMapping("/delivery")
	public String delivery() {
		
		return "/bsn/orderDelivery";
	};
	
	@GetMapping("/order/cs")
	public String orderCS() {
		
		return "redirect:/bsn/order/cs/returning";
	};
	@GetMapping("/order/cs/returning")
	public String returning() {
		
		return "/bsn/orderReturning";
	};
	
	
}
