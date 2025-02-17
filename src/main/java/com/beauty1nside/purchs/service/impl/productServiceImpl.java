package com.beauty1nside.purchs.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.beauty1nside.purchs.dto.ProductDTO;
import com.beauty1nside.purchs.dto.ProductSearchDTO;
import com.beauty1nside.purchs.mapper.productMapper;
import com.beauty1nside.purchs.service.productService;

import lombok.RequiredArgsConstructor;

@Service //★이거 무조건 넣어!!
@RequiredArgsConstructor
//@AllArgsConstructor	//모든필드를 생성자 초기화 한다
//필드 하나뿐이면 그냥 all 하고 여러개이면 Required
public class productServiceImpl implements productService{
	
	private final productMapper productMapper;
	
	@Override
	public void register(ProductDTO product) {
		productMapper.insert(product);
		
	}

	@Override
	public List<ProductDTO> getCatelist() {
		return productMapper.catelist();
	}

	@Override
	public List<ProductDTO> getBrandlist(ProductSearchDTO dto) {
		return productMapper.brandlist(dto);
	}
	
	@Override
	public int brandcount(ProductSearchDTO dto) {
		return productMapper.brandcount(dto);
	}

	@Override
	public List<ProductDTO> getVendorlist(ProductSearchDTO dto) {
		return productMapper.vendorlist(dto);
	}

	@Override
	public int vendorcount(ProductSearchDTO dto) {
		return productMapper.vendorcount(dto);
	}

	@Override
	public List<ProductDTO> getWarehouselist(ProductSearchDTO dto) {
		return productMapper.warehouselist(dto);
	}

	@Override
	public int warehousecount(ProductSearchDTO dto) {
		return productMapper.warehousecount(dto);
	}
	

}
