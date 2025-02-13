package com.beauty1nside.bhf.mapper;

import java.util.List;

import com.beauty1nside.bhf.dto.goodsorder.BhfGoodsOpDTO;
import com.beauty1nside.bhf.dto.goodsorder.BhfOrdVO;

public interface BhfOrderMapper {

	//발주 인서트 프로시져
	public void orderPrd(BhfOrdVO vo);
	
	//상품 조회
	public List<BhfGoodsOpDTO> goodsList();
	
	//옵션 조회
	public BhfGoodsOpDTO optionList(String goodsCode);

	
}
