package com.beauty1nside.bhf.service;

import java.util.List;

import com.beauty1nside.bhf.dto.goodsorder.BhfGoodsOpDTO;
import com.beauty1nside.bhf.dto.goodsorder.BhfOrdVO;

public interface BhfOrderService {

	public void orderPrd(BhfOrdVO vo);
	
	public List<BhfGoodsOpDTO> goodsList();
	
	public BhfGoodsOpDTO optionList(String goodsCode);
	
}
