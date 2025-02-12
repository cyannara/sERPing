package com.beauty1nside.accnut.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.beauty1nside.accnut.dto.AssetDTO;
import com.beauty1nside.accnut.service.AssetService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2	//log4j 가 안되면 버전높은 log4j2 사용
@RestController
@AllArgsConstructor
@RequestMapping("/accnut/rest/*")
public class AccnutRestController {

	final AssetService assetService;
	
	@GetMapping("/list")
	public List<AssetDTO> list() {
		return assetService.list();
	}
	
	@GetMapping("/listTest")
	public Object listTest() throws JsonMappingException, JsonProcessingException {
		List<AssetDTO> result = assetService.list();
		String str = """
		{
		  "result": true,
		  "data": {
				  "contents": []
				  
				  }
		}
						""";
		/*
		 ,"pagination": {
								  "page": 1,
								  "totalCount": 100
								}
		 */
		
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Object> map = objectMapper.readValue(str, Map.class);
		Map<String, Object> data = (Map) map.get("data");
		Map<String, Object> pagination = (Map) data.get("pagination");
		
		data.put("contents", result);
		
		return map;
	}
	
	
}
