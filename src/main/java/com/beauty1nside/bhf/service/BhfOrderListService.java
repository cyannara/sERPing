package com.beauty1nside.bhf.service;

import java.util.List;

import com.beauty1nside.bhf.dto.goodsorderlist.BhfOrdListDTO;
import com.beauty1nside.bhf.dto.goodsorderlist.BhfOrdListSearchDTO;

public interface BhfOrderListService {

	public List<BhfOrdListDTO> orderList(BhfOrdListSearchDTO dto);
	
	int count(BhfOrdListSearchDTO dto);
	
	public List<BhfOrdListDTO> orderDetailList(BhfOrdListSearchDTO dto);
	
}
