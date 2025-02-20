package com.beauty1nside.bhf.mapper;

import java.util.List;

import com.beauty1nside.bhf.dto.MergeTestVO;

public interface MergeTest {

	// 상품 입고 - List<BhfGoodsInVO> 데이터를 받아 MERGE 실행
    int goodsIn(List<MergeTestVO> goodsList);
	
}
