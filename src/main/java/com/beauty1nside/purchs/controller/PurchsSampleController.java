package com.beauty1nside.purchs.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.beauty1nside.purchs.dto.ProductDTO;
import com.beauty1nside.purchs.service.productService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2	//log4j 가 안되면 버전높은 log4j2 사용
@Controller
@AllArgsConstructor
@RequestMapping("/purchs/*")
public class PurchsSampleController {
	
	private final productService productService;

	//샘플 페이지
	@GetMapping("/")
	public String sample() {
		return "/purchs/sample"; // 페이지 출력 
	};
	

	//등록 페이지 이동
	@GetMapping("/register")
	public void showRegister(Model model) {
		model.addAttribute("ProductDTO", new ProductDTO());
	    model.addAttribute("catelist", productService.getCatelist()); // 빈 객체라도 전달
	}
	
	//브랜드 모달 데이터 전송 
	@GetMapping("/brandTable")
	@ResponseBody
	public List<ProductDTO> getBrandList() {
		System.out.println("컨트롤"+ productService.getBrandlist());
	    return productService.getBrandlist(); // JSON으로 반환
	}
	
	


	
	
	
}
