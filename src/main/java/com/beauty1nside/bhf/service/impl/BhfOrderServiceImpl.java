package com.beauty1nside.bhf.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beauty1nside.bhf.dto.goodsorder.BhfGoodsOpDTO;
import com.beauty1nside.bhf.dto.goodsorder.BhfOrdSearchDTO;
import com.beauty1nside.bhf.dto.goodsorder.BhfOrdVO;
import com.beauty1nside.bhf.mapper.BhfOrderMapper;
import com.beauty1nside.bhf.service.BhfOrderService;

@Service
public class BhfOrderServiceImpl implements BhfOrderService {
	
	@Autowired
	private BhfOrderMapper mapper;

	@Override
	public void orderPrd(BhfOrdVO vo) {
		
		mapper.orderPrd(vo);
	}

	@Override
	public List<BhfGoodsOpDTO> goodsList(BhfOrdSearchDTO dto) {
		
		return mapper.goodsList(dto);
	}

	@Override
	public BhfGoodsOpDTO optionList(String goodsCode) {
		
		return mapper.optionList(goodsCode);
	}

	@Override
	public int count(BhfOrdSearchDTO dto) {
		
		return mapper.count(dto);
	}

}
