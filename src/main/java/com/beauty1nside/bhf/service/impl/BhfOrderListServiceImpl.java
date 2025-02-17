package com.beauty1nside.bhf.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beauty1nside.bhf.dto.goodsorderlist.BhfOrdCancelDTO;
import com.beauty1nside.bhf.dto.goodsorderlist.BhfOrdListDTO;
import com.beauty1nside.bhf.dto.goodsorderlist.BhfOrdListSearchDTO;
import com.beauty1nside.bhf.mapper.BhfOrderListMapper;
import com.beauty1nside.bhf.service.BhfOrderListService;

@Service
public class BhfOrderListServiceImpl implements BhfOrderListService {
	
	@Autowired
	private BhfOrderListMapper mapper;

	@Override
	public List<BhfOrdListDTO> orderList(BhfOrdListSearchDTO dto) {
		
		return mapper.orderList(dto);
	}

	@Override
	public int count(BhfOrdListSearchDTO dto) {
		
		return mapper.count(dto);
	}

	@Override
	public List<BhfOrdListDTO> orderDetailList(BhfOrdListSearchDTO dto) {
		
		return mapper.orderDetailList(dto);
	}

	@Override
	public boolean orderCancel(BhfOrdCancelDTO dto) {
		
		return mapper.orderCancel(dto) == 1 ? true : false;
	}

}
