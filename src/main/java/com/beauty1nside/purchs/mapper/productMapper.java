package com.beauty1nside.purchs.mapper;

import java.util.List;

import com.beauty1nside.purchs.dto.ProductDTO;

public interface productMapper {
	//카테고리 조회 (드롭박스)
	List<ProductDTO>catelist();
	
	//브랜드 조회 (모달)
	List<ProductDTO>brandlist();
	
	//상품,옵션 등록 
	int insert(ProductDTO productDTO);
}
