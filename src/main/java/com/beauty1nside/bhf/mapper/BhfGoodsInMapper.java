package com.beauty1nside.bhf.mapper;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.beauty1nside.bhf.dto.goodsin.BhfGoodsInVO;

public interface BhfGoodsInMapper {

	 // 상품 입고 - List<BhfGoodsInVO> 데이터를 받아 MERGE 실행
    int goodsIn(@Param("list") List<BhfGoodsInVO> goodsList);
	
}
