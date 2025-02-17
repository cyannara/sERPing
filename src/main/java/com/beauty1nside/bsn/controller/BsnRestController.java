package com.beauty1nside.bsn.controller;

import java.util.Date;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.beauty1nside.bsn.dto.BhfOrderDTO;
import com.beauty1nside.bsn.dto.OrderSearchDTO;
import com.beauty1nside.bsn.service.BsnOrderService;
import com.beauty1nside.common.GridArray;
import com.beauty1nside.common.Paging;
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
	public Object order(@RequestParam(name = "perPage", defaultValue = "5", required = false) int perPage,
			@RequestParam(name ="page", defaultValue = "1", required = false) int page,
//			@RequestParam(name ="deteOption", defaultValue = "notSelect", required = false) String deteOption,
//			@RequestParam(name ="startDate",  required = false) Date startDate,
//			@RequestParam(name ="endDate", required = false) Date endDate,
//			@RequestParam(name ="selectBhf", defaultValue = "all", required = false) String selectBhf,
			OrderSearchDTO searchDTO, Paging paging) throws JsonMappingException, JsonProcessingException  {
		
		
		
		//한 페이지에 출력할 수 : 기본값: 5
		paging.setPageUnit(perPage);
		//현재 페이지(기본값: 1)
		paging.setPage(page);
		
		
		
//		//rest 데이터 형태
//		String str = """
//				{
//		  "result": true,
//		  "data": {
//		    "contents": [],
//		    "pagination": {
//		      "page": 1,
//		      "totalCount": 100
//		    }
//		  }
//		}
//						""";
//		
//		ObjectMapper objectMapper = new ObjectMapper();
//		Map<String, Object> map = objectMapper.readValue(str, Map.class);
//		Map<String, Object> data = (Map) map.get("data");
		
		//첫 페이지, 마지막 페이지
		searchDTO.setStart(paging.getFirst());
		searchDTO.setEnd(paging.getLast());
		
		// 날짜 값이 빈 문자열("")로 넘어오면 null로 설정


		
		
		GridArray grid = new GridArray();
		Object result = grid.getArray(paging.getPage(), bsnOrderService.getCountOfBhfOrder(searchDTO), bsnOrderService.getBhfOrder(searchDTO) );
		
		//페이징을 위해 검색결과 수 구하기
		//paging.setTotalRecord(bsnOrderService.getCountOfBhfOrder(searchDTO));
		
		
		
		//검색결과 - 해당 페이지 내용
//		data.put("contents", bsnOrderService.getBhfOrder(searchDTO));
//		data.put("pagination", bsnOrderService.getCountOfBhfOrder(searchDTO));
//		return map;
		
		return result;		
				
		
	};
	
	@GetMapping("/order/detail")
	public Object orderDetail(@RequestParam(name = "perPage", defaultValue = "5", required = false) int perPage,
			@RequestParam(name ="page", defaultValue = "1", required = false) int page,
			@RequestParam(name = "orderCode", defaultValue = "bhf_ord1") String orderCode,
			BhfOrderDTO dto, Paging paging) throws JsonMappingException, JsonProcessingException  {
		
		
		//한 페이지에 출력할 수 : 기본값: 5
		paging.setPageUnit(perPage);
		//현재 페이지(기본값: 1)
		paging.setPage(page);
		
		
		
		
		
		//첫 페이지, 마지막 페이지
		dto.setStart(paging.getFirst());
		dto.setEnd(paging.getLast());
		dto.setOrderCode(orderCode);
		
		GridArray grid = new GridArray();
		Object result = grid.getArray(paging.getPage(), bsnOrderService.getCountOfBhfOrderDetail(dto), bsnOrderService.getBhfOrderDetail(dto) );
		

		
		return result;		
				
		
	};
}
