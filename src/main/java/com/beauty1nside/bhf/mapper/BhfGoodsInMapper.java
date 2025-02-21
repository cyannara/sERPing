package com.beauty1nside.bhf.mapper;

import java.util.List;

import com.beauty1nside.bhf.dto.goodsin.BhfGoodsInVO;
import com.beauty1nside.bhf.dto.goodsin.BhfGoodsOrdDTO;
import com.beauty1nside.bhf.dto.goodsin.BhfGoodsOrdSearchDTO;

public interface BhfGoodsInMapper {

	 // 상품 입고 - List<BhfGoodsInVO> 데이터를 받아 MERGE 실행
    int goodsIn(List<BhfGoodsInVO> goodsList);
    
    // 발송완료인 주문서 조회
    List<BhfGoodsOrdDTO> goodsOrdList(BhfGoodsOrdSearchDTO dto);
    
    // 페이징 카운트
    int count(BhfGoodsOrdSearchDTO dto);
    
    // 주문서 상세 조회
    List<BhfGoodsOrdDTO> goodsOrdDtlList(BhfGoodsOrdSearchDTO dto);
	
}