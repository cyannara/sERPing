package com.beauty1nside.bhf.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.beauty1nside.bhf.dto.erpboard.ErpBoardListDTO;
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
	
	@PostMapping("/board/request")
	//ResponseEntity<?> => HTTP 응답을 반환할 때 응답 상태 코드, 헤더, 바디를 모두 관리할 수 있는 객체, <?>는 응답의 바디에 어떤 타입도 넣을 수 있게 허용
	public ResponseEntity<?> registerBoard(@RequestBody ErpBoardListDTO dto) {
		Map<String, Object> response = new HashMap<>();
	    try {
	        // 게시글 등록 서비스 호출, 영향을 받은 행의 수 반환
	        int result = service.boardRequest(dto);
	
	        if (result > 0) {
	        	response.put("success", true);
	            response.put("message", "게시글 등록이 완료되었습니다.");
	            return ResponseEntity.ok().body(response);
	        } else {
	            response.put("success", false);
	            response.put("message", "게시글 등록에 실패했습니다.");
	            return ResponseEntity.status(500).body(response);
	        }
	    } catch (Exception e) {
	        response.put("success", false);
	        response.put("message", "게시글 등록에 실패했습니다.");
	        return ResponseEntity.status(500).body(response);
	    }
	}
	
	@PutMapping("/board/modify")
    public Map<String, Object> updateBoard(@RequestBody ErpBoardListDTO dto) {
        Map<String, Object> response = new HashMap<>();
        boolean success = service.boardModify(dto);
        response.put("success", success);
        response.put("message", success ? "게시글이 수정되었습니다." : "게시글 수정에 실패했습니다.");
        return response;
    }
	
	@DeleteMapping("/board/del")
    public Map<String, Object> deleteBoard(@RequestParam int boardId) {
        Map<String, Object> response = new HashMap<>();
        boolean success = service.boardDelete(boardId);

        response.put("success", success);
        response.put("message", success ? "게시글이 삭제되었습니다." : "게시글 삭제에 실패했습니다.");
        return response;
    }
	
}
