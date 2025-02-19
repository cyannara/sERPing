package com.beauty1nside.bhf.service;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.beauty1nside.bhf.dto.goodsin.BhfGoodsInVO;

public interface BhfGoodsInService {

	int goodsIn(@Param("list") List<BhfGoodsInVO> goodsList);
	
}
