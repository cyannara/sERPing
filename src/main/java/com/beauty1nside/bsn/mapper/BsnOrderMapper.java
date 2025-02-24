package com.beauty1nside.bsn.mapper;

import java.util.List;

import com.beauty1nside.bsn.dto.BhfOrderDTO;
import com.beauty1nside.bsn.dto.BhfOrderDetailDTO;
import com.beauty1nside.bsn.dto.BsnGoodsLOTDTO;
import com.beauty1nside.bsn.dto.BsnOrderDTO;
import com.beauty1nside.bsn.dto.BsnOrderDetailDTO;
import com.beauty1nside.bsn.dto.OrderSearchDTO;


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
	
	
	
	
	//상품 재고 LOT별 조회(임시)
	List<BsnGoodsLOTDTO> selectGoodsWarehouseLot(BsnOrderDetailDTO bsnOrderDetailDTO);
}
