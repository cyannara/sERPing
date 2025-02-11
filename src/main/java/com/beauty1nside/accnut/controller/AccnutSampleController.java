package com.beauty1nside.accnut.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.beauty1nside.accnut.dto.AssetDTO;
import com.beauty1nside.accnut.service.AssetService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2	//log4j 가 안되면 버전높은 log4j2 사용
@RestController
@AllArgsConstructor
@RequestMapping("/accnut/rest/*")
public class AccnutSampleController {

	final AssetService assetService;
	
	@GetMapping("/list")
	public List<AssetDTO> list() {
		return assetService.list();
	}
	
	
}