package com.beauty1nside.bhf.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.beauty1nside.accnut.dto.AssetSearchDTO;
import com.beauty1nside.bhf.dto.goodsorder.BhfOrdDtlVO;
import com.beauty1nside.bhf.dto.goodsorder.BhfOrdSearchDTO;
import com.beauty1nside.bhf.dto.goodsorder.BhfOrdVO;
import com.beauty1nside.bhf.service.BhfOrderService;
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
public class BhfRestController {

	BhfOrderService bhforderservice;
	
	// 상품조회 및 상품검색
	@GetMapping("/goods/list")
	public Object goodsList(@RequestParam(name = "perPage", defaultValue = "2", required = false) int perPage, 
			@RequestParam(name = "page", defaultValue = "1", required = false) int page, 
			BhfOrdSearchDTO dto, Paging paging) throws JsonMappingException, JsonProcessingException {
		// 페이징 유닛 수
		paging.setPageUnit(perPage);
		paging.setPage(page);
		
		log.info(dto);
		
		// 페이징 조건
		dto.setStart(paging.getFirst());
		dto.setEnd(paging.getLast());
		
		// 페이징 처리
		paging.setTotalRecord(bhforderservice.count(dto));
		
		// grid 배열 처리
		GridArray grid = new GridArray();
		Object result = grid.getArray( paging.getPage(), bhforderservice.count(dto), bhforderservice.goodsList(dto) );
		return result;
	}
	
	// 옵션조회
	@GetMapping("/option/list")
	public Object optionList(@RequestParam(name = "perPage", defaultValue = "2", required = false) int perPage, 
			@RequestParam(name = "page", defaultValue = "1", required = false) int page, 
			// 화면에서 보내주는 goodsCode받기
			@RequestParam(name = "goodsCode", required = false) String goodsCode,
			BhfOrdSearchDTO dto, Paging paging) throws JsonMappingException, JsonProcessingException {
		// 페이징 유닛 수
		paging.setPageUnit(perPage);
		paging.setPage(page);
		
		log.info(dto);
		
		// 페이징 조건
		dto.setStart(paging.getFirst());
		dto.setEnd(paging.getLast());
		
		// 페이징 처리
		paging.setTotalRecord(bhforderservice.count(dto));
		
		// grid 배열 처리
		GridArray grid = new GridArray();
		Object result = grid.getArray( paging.getPage(), bhforderservice.count(dto), bhforderservice.optionList(goodsCode) );//goodsCode넣기
		return result;
	}
	
	// 발주서 등록
	@PostMapping("/order/insert")
	public BhfOrdVO ordinsert(@RequestBody BhfOrdDtlVO bodvo) {
		
		return null;
	}
	
}
