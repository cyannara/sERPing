package com.beauty1nside.bhf.mapper;

import java.util.List;

import com.beauty1nside.bhf.dto.goodsin.BhfGoodsInVO;
import com.beauty1nside.bhf.dto.goodsin.BhfGoodsOrdDTO;
import com.beauty1nside.bhf.dto.goodsin.BhfGoodsOrdSearchDTO;

public interface BhfGoodsInMapper {

	 // 상품 입고 등록 프로시저
    public void goodsIn(BhfGoodsInVO vo);
    
    // 발송완료인 주문서 조회
    List<BhfGoodsOrdDTO> goodsOrdList(BhfGoodsOrdSearchDTO dto);
    
    // 페이징 카운트
    int count(BhfGoodsOrdSearchDTO dto);
    
    // 주문서 상세 조회
    List<BhfGoodsOrdDTO> goodsOrdDtlList(BhfGoodsOrdSearchDTO dto);
	
}