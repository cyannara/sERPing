package com.beauty1nside.purchs.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.beauty1nside.purchs.dto.ProductDTO;
import com.beauty1nside.purchs.mapper.productMapper;
import com.beauty1nside.purchs.service.productService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

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
	public List<ProductDTO> getBrandlist() {
		return productMapper.brandlist();
	}

}
