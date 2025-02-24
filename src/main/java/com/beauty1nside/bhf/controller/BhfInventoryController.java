package com.beauty1nside.bhf.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.beauty1nside.bhf.dto.inventory.BhfInventoryInsertDTO;
import com.beauty1nside.bhf.dto.inventory.BhfInventoryListSearchDTO;
import com.beauty1nside.bhf.service.BhfInventoryService;
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
public class BhfInventoryController {
	
	BhfInventoryService service;
	
	// 창고 재고 조회
	@GetMapping("/inventory/list")
	public Object inventoryList(@RequestParam(name = "perPage", defaultValue = "2", required = false) int perPage, 
							@RequestParam(name = "page", defaultValue = "1", required = false) int page, 
							BhfInventoryListSearchDTO dto, Paging paging) throws JsonMappingException, JsonProcessingException {
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
		Object result = grid.getArray( paging.getPage(), service.count(dto), service.warehouseList(dto) );
		return result;
	}
	
	// 조정 등록
	@PostMapping("/insert/update")
	public ResponseEntity<Map<String, Object>> mediationInsert(@RequestBody Map< String, List<BhfInventoryInsertDTO> > requestData) {
	    Map<String, Object> response = new HashMap<>();
	    
	    // 클라이언트가 보낸 데이터에서 mediationList(데이터가 있는 배열) 추출
	    List<BhfInventoryInsertDTO> dtoList = requestData.get("mediationList"); // 객체 내부의 배열 가져오기
	    
	    try {
	        for (BhfInventoryInsertDTO dto : dtoList) {
	            // 각 DTO에 대해 조정 등록 및 창고 수량 업데이트 처리
	            boolean result = service.mediationInsert(dto);
	            
	            if (!result) {
	                response.put("status", "error");
	                response.put("message", "조정 등록 실패");
	                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
	            }
	        }

	        response.put("status", "success");
	        response.put("message", "조정 등록 및 창고 업데이트 성공");
	        return ResponseEntity.ok(response);
	    } catch (Exception e) {
	        log.error("조정 등록 실패", e);
	        response.put("status", "error");
	        response.put("message", "조정 등록 및 창고 업데이트 실패");
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
	    }
	} 
	
	// 조정 내역 조회
	@GetMapping("/inventory/history")
	public Object invenHistory(@RequestParam(name = "perPage", defaultValue = "2", required = false) int perPage, 
							@RequestParam(name = "page", defaultValue = "1", required = false) int page, 
							BhfInventoryListSearchDTO dto, Paging paging) throws JsonMappingException, JsonProcessingException {
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
		Object result = grid.getArray( paging.getPage(), service.count(dto), service.invenHistory(dto) );
		return result;
	}

}
