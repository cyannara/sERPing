package com.beauty1nside.bhf.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.beauty1nside.bhf.dto.erpboard.ErpBoardListSearchDTO;
import com.beauty1nside.bhf.service.ErpBoardService;
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
public class ErpBoardController {

	ErpBoardService service;
	
	@GetMapping("/board/list")
	public Object goodsList(@RequestParam(name = "perPage", defaultValue = "2", required = false) int perPage, 
			@RequestParam(name = "page", defaultValue = "1", required = false) int page, 
			ErpBoardListSearchDTO dto, Paging paging) throws JsonMappingException, JsonProcessingException {
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
		Object result = grid.getArray( paging.getPage(), service.count(dto), service.boardList(dto) );
		return result;
	}
	
}
