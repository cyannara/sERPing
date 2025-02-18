package com.beauty1nside.purchs.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.beauty1nside.common.GridArray;
import com.beauty1nside.common.Paging;
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
}
	
