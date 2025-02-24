package com.beauty1nside.bsn.mapper;

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


public interface BsnOrderMapper {
	
	// 발주신청 조회
	List<BhfOrderDTO> selectBhfOrder(OrderSearchDTO orderSearchDTO);
	
	//발주신청건수 확인
	int getCountOfBhfOrder(OrderSearchDTO orderSearchDTO);
	
	//발주신청 상세 조회
	List<BhfOrderDetailDTO> selectBhfOrderDetail(BhfOrderDTO bhfOrderDTO); 
	
	//발주신청의 상품수 확인
	int getCountOfBhfOrderDetail(BhfOrderDTO bhfOrderDTO);
	
	//주문 등록
	void insertBsnOrder(BsnOrderDTO bsnOrderDTO);
	
	//발주신청 취소
	void updateCancelBhfOrder(BhfOrderDTO bhfOrderDTO);
	
	
	
	
	//주문 조회
	List<BsnOrderDTO> selectBsnOrder(OrderSearchDTO orderSearchDTO);
	//주문건수 확인
	int getCountOfBsnOrder(OrderSearchDTO orderSearchDTO);
	
	//주문 상세 조회
	List<BsnOrderDetailDTO> selectBsnOrderDetail(BsnOrderDTO bsnOrderDTO);
	
	int getCountOfBsnOrderDetail(BsnOrderDTO bsnOrderDTO);
	
	
	
	
	//출고 조회
	List<BsnDeliveryDTO> selectBsnDelivery(OrderSearchDTO orderSearchDTO);
	
	//출고 상세조회
	List<BsnDeliveryDetailDTO> selectBsnDeliveryDetail(BsnDeliveryDTO bsnDeliveryDTO);
	
	//출고 LOT 상세 조회
	List<BsnDeliveryLotDTO> selectBsnDeliveryLotDTO(BsnDeliveryDetailDTO bsnDeliveryDetailDTO);
	
	//상품 재고 LOT별 조회(임시)
	List<BsnGoodsLOTDTO> selectGoodsWarehouseLot(BsnOrderDetailDTO bsnOrderDetailDTO);
}
