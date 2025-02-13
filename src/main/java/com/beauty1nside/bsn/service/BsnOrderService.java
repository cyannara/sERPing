package com.beauty1nside.bsn.service;

import java.util.List;

import com.beauty1nside.bsn.dto.BhfOrderDTO;
import com.beauty1nside.bsn.dto.OrderSearchDTO;

public interface BsnOrderService {

	
	//발주 주문 조회
	public List<BhfOrderDTO> getBhfOrder(OrderSearchDTO orderSearchDTO);
	//발주 주문수 구하기
	public int getCountOfBhfOrder(OrderSearchDTO orderSearchDTO);
}
