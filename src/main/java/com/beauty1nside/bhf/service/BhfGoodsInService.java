package com.beauty1nside.bhf.service;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.beauty1nside.bhf.dto.goodsin.BhfGoodsInVO;
import com.beauty1nside.bhf.dto.goodsin.BhfGoodsOrdDTO;
import com.beauty1nside.bhf.dto.goodsin.BhfGoodsOrdSearchDTO;

public interface BhfGoodsInService {

	int goodsIn(List<BhfGoodsInVO> goodsList);
	
	List<BhfGoodsOrdDTO> goodsOrdList(BhfGoodsOrdSearchDTO dto);
	
	int count(BhfGoodsOrdSearchDTO dto);
	
	List<BhfGoodsOrdDTO> goodsOrdDtlList(BhfGoodsOrdSearchDTO dto);
	
}
