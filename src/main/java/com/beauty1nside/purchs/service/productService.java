package com.beauty1nside.purchs.service;

import java.util.List;

import com.beauty1nside.purchs.dto.ProductDTO;

public interface productService {
	//카테고리 조회 
	public List<ProductDTO> getCatelist();
	
	//브랜드 조회
	public List<ProductDTO> getBrandlist();
	
	//상품등록 (옵션 등록)
	public void register(ProductDTO product);
	
	
}
