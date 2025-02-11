package com.beauty1nside.erp.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.beauty1nside.erp.dto.testDTO;
import com.beauty1nside.erp.service.ErpAdminService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController	//★★★
@AllArgsConstructor
@RequestMapping("/erp/rest/*")
public class ErpAdminRestController {
	
	private final ErpAdminService erpAdminService;
	
	@GetMapping("/list")
	public List<testDTO> getlist(){
		List<testDTO> list = erpAdminService.test();
		log.info(list.toString());
		return list;
	}

}
