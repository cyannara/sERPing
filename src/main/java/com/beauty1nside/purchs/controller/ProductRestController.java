package com.beauty1nside.purchs.controller;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.beauty1nside.common.GridArray;
import com.beauty1nside.common.Paging;
import com.beauty1nside.purchs.dto.ProdInsertVO;
import com.beauty1nside.purchs.dto.ProductSearchDTO;
import com.beauty1nside.purchs.service.productService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;


@Log4j2	//log4j 가 안되면 버전높은 log4j2 사용
@RestController
@AllArgsConstructor
@RequestMapping("/purchs/rest*")
public class ProductRestController {
	final productService productService;
	
	//브랜드 모달 데이터 조회 
	@GetMapping("/brand/list")
	public Object brandList(@RequestParam(name="perPage",defaultValue="2", required = false) int perPage,
							@RequestParam(name="page", defaultValue = "1" ,required = false) int page,
							@ModelAttribute ProductSearchDTO dto, Paging paging) throws JsonMappingException, JsonProcessingException {
		
		log.info("정보==",dto.getBrandName());
		
		//페이징 유닛 수 
		paging.setPageUnit(perPage);
		paging.setPage(page);
		
		//페이징 조건
		dto.setStart(paging.getFirst());
		dto.setEnd(paging.getLast());
		
		//페이징 처리 
		paging.setTotalRecord(productService.brandcount(dto));
		
		//grid배열 처리 
		GridArray grid = new GridArray();
		Object result = grid.getArray(paging.getPage(), productService.brandcount(dto), productService.getBrandlist(dto));
		return result;
	
	}
	
	//거래처 모달 데이터 조회 
	@GetMapping("/vendor/list")
	public Object vendorList(@RequestParam(name="perPage",defaultValue="2", required = false) int perPage,
							@RequestParam(name="page", defaultValue = "1" ,required = false) int page,
							@ModelAttribute ProductSearchDTO dto, Paging paging) throws JsonMappingException, JsonProcessingException {
		
		
		//페이징 유닛 수 
		paging.setPageUnit(perPage);
		paging.setPage(page);
		
		//페이징 조건
		dto.setStart(paging.getFirst());
		dto.setEnd(paging.getLast());
		
		//페이징 처리 
		paging.setTotalRecord(productService.vendorcount(dto));
		
		//grid배열 처리 
		GridArray grid = new GridArray();
		Object result = grid.getArray(paging.getPage(), productService.vendorcount(dto), productService.getVendorlist(dto));
		return result;
	
	}
	
	//창고 모달 데이터 조회 
		@GetMapping("/warehouse/list")
		public Object warehouseList(@RequestParam(name="perPage",defaultValue="2", required = false) int perPage,
								@RequestParam(name="page", defaultValue = "1" ,required = false) int page,
								@ModelAttribute ProductSearchDTO dto, Paging paging) throws JsonMappingException, JsonProcessingException {
			
			
			//페이징 유닛 수 
			paging.setPageUnit(perPage);
			paging.setPage(page);
			
			//페이징 조건
			dto.setStart(paging.getFirst());
			dto.setEnd(paging.getLast());
			
			//페이징 처리 
			paging.setTotalRecord(productService.warehousecount(dto));
			
			//grid배열 처리 
			GridArray grid = new GridArray();
			Object result = grid.getArray(paging.getPage(), productService.warehousecount(dto), productService.getWarehouselist(dto));
			return result;
		
		}
		
		
	//이미지 업로드
		@PostMapping("/product/uploadGoodsImages")
		public ResponseEntity<Map<String, Object>> uploadFile(@RequestParam("file") MultipartFile file) {
		    Map<String, Object> response = new HashMap<>();
		    String UPLOAD_DIR = "C:/atest/";

		    try {
		        if (file.isEmpty()) {
		            response.put("success", false);
		            response.put("message", "업로드할 파일이 없습니다.");
		            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		        }

		        // 1️ 원본 파일명에서 확장자 추출 (.jpg, .png 등)
		        String originalFileName = file.getOriginalFilename();
		        String fileExtension = "";
		        if (originalFileName != null && originalFileName.contains(".")) {
		            fileExtension = originalFileName.substring(originalFileName.lastIndexOf(".")); 
		        }

		        // 2️ UUID를 이용한 고유한 파일명 생성
		        String uniqueFileName = UUID.randomUUID().toString() + fileExtension;

		        // 3️ 파일 저장 경로 설정
		        Path savePath = Paths.get(UPLOAD_DIR + uniqueFileName);
		        file.transferTo(savePath.toFile());

		        // 4️ 응답 데이터 설정
		        response.put("success", true);
		        response.put("message", "파일 업로드 성공");
		        response.put("fileName", uniqueFileName);  // 고유한 파일명 반환

		        return ResponseEntity.ok(response);
		        
		    } catch (IOException e) {
		        e.printStackTrace();
		        response.put("success", false);
		        response.put("message", "파일 저장 중 오류 발생: " + e.getMessage());
		        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
		    } catch (Exception e) {
		        e.printStackTrace();
		        response.put("success", false);
		        response.put("message", "예상치 못한 오류 발생: " + e.getMessage());
		        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
		    }
		}
		
		//상품 등록
		@PostMapping("/product/insert")
		// Map을 같이 사용해서 status,message 등을 사용 가능하다
		// ProdInsertVO 안에 List<ProInsertDtlVO> files 있어서 ProInsertDtlVO를 따로 넣지 않아도 된다.
		public ResponseEntity<Map<String,Object>> productInsert(@RequestBody ProdInsertVO prodInsertVO){
			Map<String, Object> response = new HashMap<>();
			 try {
				productService.goodsinsert(prodInsertVO);
				response.put("status", "success");
				response.put("message", "제품 등록 성공");
				return ResponseEntity.ok(response);
			 } catch(Exception e) {
				 log.error("발주등록실패", e);
				 response.put("status", "error");
				 response.put("message", "제품 등록 성공");
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
			 }
			
		}
}
	
