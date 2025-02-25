package com.beauty1nside.bhf.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beauty1nside.bhf.dto.goodsin.BhfGoodsInVO;
import com.beauty1nside.bhf.dto.goodsin.BhfGoodsOrdDTO;
import com.beauty1nside.bhf.dto.goodsin.BhfGoodsOrdSearchDTO;
import com.beauty1nside.bhf.mapper.BhfGoodsInMapper;
import com.beauty1nside.bhf.service.BhfGoodsInService;

@Service
public class BhfGoodsInServiceImpl implements BhfGoodsInService {
	
	@Autowired
	private BhfGoodsInMapper mapper;

	@Override
	public void goodsIn(BhfGoodsInVO vo) {
		
		System.out.println(vo);
		mapper.goodsIn(vo);
	}

	@Override
	public List<BhfGoodsOrdDTO> goodsOrdList(BhfGoodsOrdSearchDTO dto) {
		
		return mapper.goodsOrdList(dto);
	}

	@Override
	public List<BhfGoodsOrdDTO> goodsOrdDtlList(BhfGoodsOrdSearchDTO dto) {
		
		return mapper.goodsOrdDtlList(dto);
	}

	@Override
	public int count(BhfGoodsOrdSearchDTO dto) {
		
		return mapper.count(dto);
	}

	

}