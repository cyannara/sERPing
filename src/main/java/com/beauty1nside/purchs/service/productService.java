package com.beauty1nside.purchs.service;

import java.util.List;

import com.beauty1nside.purchs.dto.ProductDTO;
import com.beauty1nside.purchs.dto.ProductSearchDTO;

public interface productService {
	//카테고리 조회 
	public List<ProductDTO> getCatelist();
	
	//브랜드 조회
	public List<ProductDTO> getBrandlist(ProductSearchDTO dto);
	int brandcount(ProductSearchDTO dto);
	
	//거래처 조회 
	public List<ProductDTO> getVendorlist(ProductSearchDTO dto);
	int vendorcount(ProductSearchDTO dto);
	
	//창고조회
	public List<ProductDTO> getWarehouselist(ProductSearchDTO dto);
	int warehousecount(ProductSearchDTO dto);
	
	//상품등록 (옵션 등록)
	public void register(ProductDTO product);
	
	
}
