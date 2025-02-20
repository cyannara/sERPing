package com.beauty1nside.bhf.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beauty1nside.bhf.dto.goodsin.BhfGoodsInVO;
import com.beauty1nside.bhf.mapper.BhfGoodsInMapper;
import com.beauty1nside.bhf.service.BhfGoodsInService;

@Service
public class BhfGoodsInServiceImpl implements BhfGoodsInService {
	
	@Autowired
	private BhfGoodsInMapper mapper;

	@Override
	public int goodsIn(List<BhfGoodsInVO> goodsList) {
		
		return mapper.goodsIn(goodsList);
	}

	

}
