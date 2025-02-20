package com.beauty1nside.bsn.service;

import java.util.List;

import com.beauty1nside.bsn.dto.BhfOrderDTO;
import com.beauty1nside.bsn.dto.BhfOrderDetailDTO;
import com.beauty1nside.bsn.dto.BsnOrderDTO;
import com.beauty1nside.bsn.dto.OrderSearchDTO;

public interface BsnOrderService {

	
	//발주 주문 조회
	public List<BhfOrderDTO> getBhfOrder(OrderSearchDTO orderSearchDTO);
	//발주 주문수 구하기
	public int getCountOfBhfOrder(OrderSearchDTO orderSearchDTO);
	
	//발주 주문 상세정보 조회
	public List<BhfOrderDetailDTO> getBhfOrderDetail(BhfOrderDTO bhfOrderDTO);
	//발주 상세의 상품수 구하기
	public int getCountOfBhfOrderDetail(BhfOrderDTO bhfOrderDTO);
	
	//주문 등록
	public void registerOrder(BsnOrderDTO bsnOrederDTO);
	
	//발주 요청 취소
	public void cancelBhfOrder(BhfOrderDTO bhfOrderDTO);
	
}
