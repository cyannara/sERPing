package com.beauty1nside.bhf.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.beauty1nside.bhf.dto.goodsin.BhfGoodsInVO;
import com.beauty1nside.bhf.dto.goodsin.BhfGoodsOrdSearchDTO;
import com.beauty1nside.bhf.service.BhfGoodsInService;
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
public class BhfGoodsInController {
	
	BhfGoodsInService service;
	
	// 상품입고 등록
	@PostMapping("/goods/in")
    public ResponseEntity<String> goodsIn(@RequestBody List<BhfGoodsInVO> goodsList) {
        int result = service.goodsIn(goodsList);
        return ResponseEntity.ok(result + " rows inserted/updated.");
    }
	
	// 주문서 조회
	@GetMapping("/bsn/order")
	public Object orderList(@RequestParam(name = "perPage", defaultValue = "2", required = false) int perPage, 
							@RequestParam(name = "page", defaultValue = "1", required = false) int page, 
							BhfGoodsOrdSearchDTO dto, Paging paging) throws JsonMappingException, JsonProcessingException {
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
		Object result = grid.getArray( paging.getPage(), service.count(dto), service.goodsOrdList(dto) );
		return result;
	}
	
	// 주문서 상세 조회
		@GetMapping("/bsn/ordlist")
		public Object orderDtlList(@RequestParam(name = "perPage", defaultValue = "2", required = false) int perPage, 
								@RequestParam(name = "page", defaultValue = "1", required = false) int page, 
								BhfGoodsOrdSearchDTO dto, Paging paging) throws JsonMappingException, JsonProcessingException {
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
			Object result = grid.getArray( paging.getPage(), service.count(dto), service.goodsOrdDtlList(dto) );
			return result;
		}

}