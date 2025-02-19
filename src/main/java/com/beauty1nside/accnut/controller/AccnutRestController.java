package com.beauty1nside.accnut.controller;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.beauty1nside.accnut.dto.AssetDTO;
import com.beauty1nside.accnut.dto.AssetSearchDTO;
import com.beauty1nside.accnut.dto.DealBookDTO;
import com.beauty1nside.accnut.dto.DealBookSearchDTO;
import com.beauty1nside.accnut.dto.DebtSearchDTO;
import com.beauty1nside.accnut.dto.EtcBookSearchDTO;
import com.beauty1nside.accnut.dto.IncidentalCostSearchDTO;
import com.beauty1nside.accnut.dto.SalaryBookSearchDTO;
import com.beauty1nside.accnut.service.AssetService;
import com.beauty1nside.accnut.service.DealBookService;
import com.beauty1nside.accnut.service.DebtService;
import com.beauty1nside.accnut.service.EtcBookService;
import com.beauty1nside.accnut.service.IncidentalCostService;
import com.beauty1nside.accnut.service.SalaryBookService;
import com.beauty1nside.common.GridArray;
import com.beauty1nside.common.GridData;
import com.beauty1nside.common.Paging;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2	//log4j 가 안되면 버전높은 log4j2 사용
@RestController
@AllArgsConstructor
@RequestMapping("/accnut/rest/*")
public class AccnutRestController {

	final AssetService assetService;
	final DebtService debtService;
	final DealBookService dealBookService;
	final SalaryBookService salaryBookService;
	final EtcBookService etcBookService;
	final IncidentalCostService incidentalCostService;
	
	
	@GetMapping("/asset/list")
	public Object assetList(@RequestParam(name = "perPage", defaultValue = "5", required = false) int perPage, 
			@RequestParam(name = "page", defaultValue = "1", required = false) int page, 
			AssetSearchDTO dto, Paging paging) throws JsonMappingException, JsonProcessingException {
		// 페이징 유닛 수
		paging.setPageUnit(perPage);
		paging.setPage(page);
		
		log.info(dto);
		
		// 페이징 조건
		dto.setStart(paging.getFirst());
		dto.setEnd(paging.getLast());
		
		// 페이징 처리
		paging.setTotalRecord(assetService.count(dto));
		
		// grid 배열 처리
		GridArray grid = new GridArray();
		Object result = grid.getArray( paging.getPage(), assetService.count(dto), assetService.list(dto) );
		return result;
	}
	
	@GetMapping("/debt/list")
	public Object debtList(@RequestParam(name = "perPage", defaultValue = "5", required = false) int perPage, 
			@RequestParam(name = "page", defaultValue = "1", required = false) int page, 
			DebtSearchDTO dto, Paging paging) throws JsonMappingException, JsonProcessingException {
		// 페이징 유닛 수
		paging.setPageUnit(perPage);
		paging.setPage(page);
		
		log.info(dto);
		
		// 페이징 조건
		dto.setStart(paging.getFirst());
		dto.setEnd(paging.getLast());
		
		// 페이징 처리
		paging.setTotalRecord(debtService.count(dto));
		
		// grid 배열 처리
		GridArray grid = new GridArray();
		Object result = grid.getArray( paging.getPage(), debtService.count(dto), debtService.list(dto) );
		return result;
	}
	
	@GetMapping("/book/list")
	public Object dealBookList(@RequestParam(name = "perPage", defaultValue = "5", required = false) int perPage, 
			@RequestParam(name = "page", defaultValue = "1", required = false) int page, 
			DealBookSearchDTO dto, Paging paging) throws JsonMappingException, JsonProcessingException {
		// 페이징 유닛 수
		paging.setPageUnit(perPage);
		paging.setPage(page);
		
		log.info(dto);
		
		// 페이징 조건
		dto.setStart(paging.getFirst());
		dto.setEnd(paging.getLast());
		
		// 페이징 처리
		paging.setTotalRecord(dealBookService.count(dto));
		
		// grid 배열 처리
		GridArray grid = new GridArray();
		Object result = grid.getArray( paging.getPage(), dealBookService.count(dto), dealBookService.list(dto) );
		return result;
	}
	
	@GetMapping("/salary/list")
	public Object salaryBookList(@RequestParam(name = "perPage", defaultValue = "5", required = false) int perPage, 
			@RequestParam(name = "page", defaultValue = "1", required = false) int page, 
			SalaryBookSearchDTO dto, Paging paging) throws JsonMappingException, JsonProcessingException {
		// 페이징 유닛 수
		paging.setPageUnit(perPage);
		paging.setPage(page);
		
		log.info(dto);
		
		// 페이징 조건
		dto.setStart(paging.getFirst());
		dto.setEnd(paging.getLast());
		
		// 페이징 처리
		paging.setTotalRecord(salaryBookService.count(dto));
		
		// grid 배열 처리
		GridArray grid = new GridArray();
		Object result = grid.getArray( paging.getPage(), salaryBookService.count(dto), salaryBookService.list(dto) );
		return result;
	}
	
	@GetMapping("/etc/list")
	public Object etcBookList(@RequestParam(name = "perPage", defaultValue = "5", required = false) int perPage, 
			@RequestParam(name = "page", defaultValue = "1", required = false) int page, 
			EtcBookSearchDTO dto, Paging paging) throws JsonMappingException, JsonProcessingException {
		// 페이징 유닛 수
		paging.setPageUnit(perPage);
		paging.setPage(page);
		
		log.info(dto);
		
		// 페이징 조건
		dto.setStart(paging.getFirst());
		dto.setEnd(paging.getLast());
		
		// 페이징 처리
		paging.setTotalRecord(etcBookService.count(dto));
		
		// grid 배열 처리
		GridArray grid = new GridArray();
		Object result = grid.getArray( paging.getPage(), etcBookService.count(dto), etcBookService.list(dto) );
		return result;
	}
	
	@GetMapping("/incidental/list")
	public Object incidentalList(@RequestParam(name = "perPage", defaultValue = "5", required = false) int perPage, 
			@RequestParam(name = "page", defaultValue = "1", required = false) int page, 
			IncidentalCostSearchDTO dto, Paging paging) throws JsonMappingException, JsonProcessingException {
		// 페이징 유닛 수
		paging.setPageUnit(perPage);
		paging.setPage(page);
		
		log.info(dto);
		
		// 페이징 조건
		dto.setStart(paging.getFirst());
		dto.setEnd(paging.getLast());
		
		// 페이징 처리
		paging.setTotalRecord(incidentalCostService.count(dto));
		
		// grid 배열 처리
		GridArray grid = new GridArray();
		Object result = grid.getArray( paging.getPage(), incidentalCostService.count(dto), incidentalCostService.list(dto) );
		return result;
	}
	
	// 삽입
	
	
	@PostMapping("/asset/insert")
	public ResponseEntity<Map<String, Object>> assetsInsert(@RequestBody AssetDTO dto) {
	    Map<String, Object> response = new HashMap<>();
	    try {
	    	assetService.insert(dto);
	        response.put("status", "success");
	        response.put("message", "등록 성공");
	        return ResponseEntity.ok(response); // JSON 형태 응답
	    } catch (Exception e) {
	        log.error("등록 실패", e);
	        response.put("status", "error");
	        response.put("message", "등록 실패");
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
	    }
	}
	
	@PostMapping("/book/insert")
	public Map register(@RequestBody GridData<DealBookDTO> dto) {
		dto.getCreatedRows().forEach(dtos -> {
			log.info("list: " + dtos);
			if(dtos.getSection() != null) {
				dealBookService.insert(dtos);
			}
		});
		
		return Collections.singletonMap("result", true);
	}
}
