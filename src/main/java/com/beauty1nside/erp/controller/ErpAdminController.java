package com.beauty1nside.erp.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.beauty1nside.erp.dto.testDTO;
import com.beauty1nside.erp.service.ErpAdminService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2	//log4j 가 안되면 버전높은 log4j2 사용
@Controller
@AllArgsConstructor
@RequestMapping("/erp/*")
public class ErpAdminController {
	
	private ErpAdminService erpAdminService;
	
	@GetMapping("dbtest")
	public String dbtest(Model model) {
		List<testDTO> list = erpAdminService.test();
		log.info(list.toString());
		model.addAttribute("list", list);
		return "/erp/dbtest";
	}
	
	@GetMapping("/main")
	public String main() {
		return "/erp/main";
	}
	

}
