package com.beauty1nside.bhf.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.beauty1nside.bhf.dto.goodsorderlist.BhfOrdCancelDTO;
import com.beauty1nside.bhf.dto.goodsorderlist.BhfOrdListSearchDTO;
import com.beauty1nside.bhf.service.BhfOrderListService;
import com.beauty1nside.common.GridArray;
import com.beauty1nside.common.Paging;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2	//log4j 가 안되면 버전높은 log4j2 사용
@RestController
@AllArgsConstructor
@RequestMapping("/bhf/rest/*")
public class BhfOrderListController {
	
	BhfOrderListService service;
	
	// 발주서조회 및 발주서검색
	@GetMapping("/order/list")
	public Object goodsList(@RequestParam(name = "perPage", defaultValue = "2", required = false) int perPage, 
			@RequestParam(name = "page", defaultValue = "1", required = false) int page, 
			BhfOrdListSearchDTO dto, Paging paging) throws JsonMappingException, JsonProcessingException {
		// 페이징 유닛 수
		paging.setPageUnit(perPage);
		paging.setPage(page);
		
		log.info(dto);
		
		// 페이징 조건
		dto.setStart(paging.getFirst());
		dto.setEnd(paging.getLast());
		
		// 페이징 처리
		paging.setTotalRecord(service.count(dto));
		
		// grid 배열 처리
		GridArray grid = new GridArray();
		Object result = grid.getArray( paging.getPage(), service.count(dto), service.orderList(dto) );
		return result;
	}
	
	// 발주서 상세 조회
	@GetMapping("/order/detail")
	public Object goodsDtlList(@RequestParam(name = "perPage", defaultValue = "10", required = false) int perPage, 
			@RequestParam(name = "page", defaultValue = "1", required = false) int page, 
			
			BhfOrdListSearchDTO dto, Paging paging) throws JsonMappingException, JsonProcessingException {
		// 페이징 유닛 수
		paging.setPageUnit(perPage);
		paging.setPage(page);
		
		log.info(dto);
		
		// 페이징 조건
		dto.setStart(paging.getFirst());
		dto.setEnd(paging.getLast());
		
		// 페이징 처리
		paging.setTotalRecord(service.count(dto));
		
		// grid 배열 처리
		GridArray grid = new GridArray();
		Object result = grid.getArray( paging.getPage(), service.count(dto), service.orderDetailList(dto) );
		return result;
	}
	
	// 발주서 취소
	@PostMapping("/order/cancel")
	public ResponseEntity<String> cancelOrder(@RequestBody BhfOrdCancelDTO dto){
		
		try {
			service.orderCancel(dto);
			return ResponseEntity.ok("발주가 취소되었습니다.");
		} catch (Exception e) {
			 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("발주 취소 중 오류 발생");
		}
	}

}
