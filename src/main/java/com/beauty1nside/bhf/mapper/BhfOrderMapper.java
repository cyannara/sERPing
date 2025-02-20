package com.beauty1nside.bhf.mapper;

import java.util.List;

import com.beauty1nside.bhf.dto.goodsorder.BhfGoodsOpDTO;
import com.beauty1nside.bhf.dto.goodsorder.BhfOrdSearchDTO;
import com.beauty1nside.bhf.dto.goodsorder.BhfOrdVO;

public interface BhfOrderMapper {

	//발주 인서트 프로시져
	public void orderPrd(BhfOrdVO vo);
	
	//상품 조회
	public List<BhfGoodsOpDTO> goodsList(BhfOrdSearchDTO dto);
	//페이징 할떄 조회되는 전체값
	int count(BhfOrdSearchDTO dto);
	
	//옵션 조회
	public List<BhfGoodsOpDTO> optionList(BhfOrdSearchDTO dto);

	
}
