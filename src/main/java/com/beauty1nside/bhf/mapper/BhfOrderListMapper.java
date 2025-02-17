package com.beauty1nside.bhf.mapper;

import java.util.List;

import com.beauty1nside.bhf.dto.goodsorderlist.BhfOrdCancelDTO;
import com.beauty1nside.bhf.dto.goodsorderlist.BhfOrdListDTO;
import com.beauty1nside.bhf.dto.goodsorderlist.BhfOrdListSearchDTO;

public interface BhfOrderListMapper {

	//발주서 조회
	public List<BhfOrdListDTO> orderList(BhfOrdListSearchDTO dto);
	//페이징 할떄 조회되는 전체값
	int count(BhfOrdListSearchDTO dto);
	
	//발주서상세 조회
	public List<BhfOrdListDTO> orderDetailList(BhfOrdListSearchDTO dto);
	
	//발주서 취소
	int orderCancel(BhfOrdCancelDTO dto);
	
}
