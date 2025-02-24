package com.beauty1nside.bsn.service;

import java.util.List;

import com.beauty1nside.bsn.dto.BsnGoodsLOTDTO;
import com.beauty1nside.bsn.dto.OrderSearchDTO;
import com.beauty1nside.bsn.dto.delivery.BsnDeliveryDTO;
import com.beauty1nside.bsn.dto.delivery.BsnDeliveryDetailDTO;
import com.beauty1nside.bsn.dto.delivery.BsnDeliveryLotDTO;
import com.beauty1nside.bsn.dto.order.BhfOrderDTO;
import com.beauty1nside.bsn.dto.order.BhfOrderDetailDTO;
import com.beauty1nside.bsn.dto.order.BsnOrderDTO;
import com.beauty1nside.bsn.dto.order.BsnOrderDetailDTO;

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
	
	
	//주문조회
	public List<BsnOrderDTO> getBsnOrder(OrderSearchDTO orderSearchDTO);
	//주문 수 구하기
	public int getCountOfBsnOrder(OrderSearchDTO orderSearchDTO);
	
	//주문상세조회
	public List<BsnOrderDetailDTO> getBsnOrderDetail(BsnOrderDTO bsnOrederDTO);
	//주문상세 수 구하기
	public int getCountOfBsnOrderDetail(BsnOrderDTO bsnOrederDTO);
	
	
	//출고 조회
	public List<BsnDeliveryDTO> getBsnDelivery(OrderSearchDTO orderSearchDTO);
	
	//출고 상세 조회
	public List<BsnDeliveryDetailDTO> getBsnDeliveryDetail(BsnDeliveryDTO bsnDeliveryDTO);
	
	
	//츨고 LOT 상세 조회
	public List<BsnDeliveryLotDTO> getBsnDeliveryLotDetail(BsnDeliveryDetailDTO bsnDeliveryDetailDTO);
	
	
	//본사 창고 재고(LOT별)조회 임시
	public List<BsnGoodsLOTDTO> getGoodsWarehouseLot(BsnDeliveryDetailDTO bsnDeliveryDetailDTO);
	
	
}
