package com.beauty1nside.bsn.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.beauty1nside.bsn.Paging;
import com.beauty1nside.bsn.dto.OrderSearchDTO;
import com.beauty1nside.bsn.service.BsnOrderService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2	//log4j 가 안되면 버전높은 log4j2 사용

@RestController
@AllArgsConstructor
@RequestMapping("/bsn/rest/*")
public class BsnRestController {
	
	final private BsnOrderService bsnOrderService;
	
	@GetMapping("/order")
	public Map<String, Object> order(@RequestParam(name = "perPage", defaultValue = "5", required = false) int perPage,
			OrderSearchDTO searchDTO, Paging paging) throws JsonMappingException, JsonProcessingException  {
		
		//한 페이지에 출력할 수 : 기본값: 5
		paging.setPageUnit(perPage);
		
		//rest 데이터 형태
		String str = """
				{
		  "result": true,
		  "data": {
		    "contents": [],
		    "pagination": {
		      "page": 1,
		      "totalCount": 100
		    }
		  }
		}
						""";
		
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Object> map = objectMapper.readValue(str, Map.class);
		Map<String, Object> data = (Map) map.get("data");
		
		//페이징을 위해 검색결과 수 구하기
		paging.setTotalRecord(bsnOrderService.getCountOfBhfOrder(searchDTO));
		
		//첫 페이지, 마지막 페이지
		searchDTO.setStart(paging.getFirst());
		searchDTO.setEnd(paging.getLast());
		
		//검색결과 - 해당 페이지 내용
		data.put("contents", bsnOrderService.getBhfOrder(searchDTO));
//		data.put("pagination", bsnOrderService.getCountOfBhfOrder(searchDTO));
		return map;
		
	};
}
