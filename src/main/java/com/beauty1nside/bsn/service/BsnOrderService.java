package com.beauty1nside.bsn.service;

import java.util.List;

import com.beauty1nside.bsn.dto.BhfOrderDTO;
import com.beauty1nside.bsn.dto.BhfOrderDetailDTO;
import com.beauty1nside.bsn.dto.OrderSearchDTO;

public interface BsnOrderService {

	
	//발주 주문 조회
	public List<BhfOrderDTO> getBhfOrder(OrderSearchDTO orderSearchDTO);
	//발주 주문수 구하기
	public int getCountOfBhfOrder(OrderSearchDTO orderSearchDTO);
	
	public List<BhfOrderDetailDTO> getBhfOrderDetail(BhfOrderDTO bhfOrderDTO);
	//발주 상세의 상품수 구하기
	public int getCountOfBhfOrderDetail(BhfOrderDTO bhfOrderDTO);
	
}
