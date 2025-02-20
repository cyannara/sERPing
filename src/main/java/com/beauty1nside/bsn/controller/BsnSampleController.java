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
	
	final private BsnOrderService bsnOrderService;

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
	
	
	@GetMapping("/orderRegist")
	public String orderRegist(
			OrderSearchDTO searchDTO, Paging paging, Model model
			) {
		
//		//페이징을 위해 검색결과 수 구하기
//		paging.setTotalRecord(bsnOrderService.getCountOfBhfOrder(searchDTO));
		
//		//첫 페이지, 마지막 페이지
//		searchDTO.setStart(paging.getFirst());
//		searchDTO.setEnd(paging.getLast());
		
//		
//		
//		//검색결과 - 해당 페이지 내용
//		model.addAttribute("bhfOrder", bsnOrderService.getBhfOrder(searchDTO));
		return "/bsn/orderRegist";
	};
	
	@GetMapping("/orderList")
	public String orderList() {
		
//		//페이징을 위해 검색결과 수 구하기
//		paging.setTotalRecord(bsnOrderService.getCountOfBhfOrder(searchDTO));
		
//		//첫 페이지, 마지막 페이지
//		searchDTO.setStart(paging.getFirst());
//		searchDTO.setEnd(paging.getLast());
		
//		
//		
//		//검색결과 - 해당 페이지 내용
//		model.addAttribute("bhfOrder", bsnOrderService.getBhfOrder(searchDTO));
		return "/bsn/orderList";
	};
	
}
