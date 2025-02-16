package com.beauty1nside.hr.controller;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.beauty1nside.common.GridArray;
import com.beauty1nside.common.Paging;
import com.beauty1nside.hr.dto.EmpSearchDTO;
import com.beauty1nside.hr.service.EmpService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@AllArgsConstructor
@RequestMapping("/hr/rest/*")
public class HrRestController {
	final EmpService empService;
	
	
	@GetMapping("/emp/list")
	public Object empList(@RequestParam(name = "perPage", defaultValue = "2", required = false) int perPage, 
			@RequestParam(name = "page", defaultValue = "1", required = false) int page, 
			EmpSearchDTO dto, Paging paging) throws JsonMappingException, JsonProcessingException {
		
		
		log.info("호출했습니다");
		
		
		// 페이징 유닛 수
		paging.setPageUnit(perPage);
		paging.setPage(page);
		
		log.info(dto);
		
		// 페이징 조건
		dto.setStart(paging.getFirst());
		dto.setEnd(paging.getLast());
		
		// 페이징 처리
		paging.setTotalRecord(empService.count(dto));
		
		log.info("empService.count(dto)::::::::::::::::",empService.count(dto));
		
		// grid 배열 처리
		GridArray grid = new GridArray();
		Object result = grid.getArray( paging.getPage(), empService.count(dto), empService.list(dto) );
		return result;
	}
	
    @GetMapping("/emp/common-codes")
    public ResponseEntity<Map<String, Object>> getCommonCodes() {
        Map<String, Object> result = empService.getCommonCodes();
        return ResponseEntity.ok(result);
    }	
	


}
