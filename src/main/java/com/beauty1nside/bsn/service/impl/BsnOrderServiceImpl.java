package com.beauty1nside.bsn.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.beauty1nside.bsn.dto.BhfOrderDTO;
import com.beauty1nside.bsn.dto.BhfOrderDetailDTO;
import com.beauty1nside.bsn.dto.BsnGoodsLOTDTO;
import com.beauty1nside.bsn.dto.BsnOrderDTO;
import com.beauty1nside.bsn.dto.BsnOrderDetailDTO;
import com.beauty1nside.bsn.dto.OrderSearchDTO;
import com.beauty1nside.bsn.mapper.BsnOrderMapper;
import com.beauty1nside.bsn.service.BsnOrderService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BsnOrderServiceImpl implements BsnOrderService {
	
	private final BsnOrderMapper bsnOrderMapper;

	//발주요청 조회
	@Override
	public List<BhfOrderDTO> getBhfOrder(OrderSearchDTO orderSearchDTO) {
		return bsnOrderMapper.selectBhfOrder(orderSearchDTO);
	}
	//발주요청 페이징용 전체 수 구하기
	@Override
	public int getCountOfBhfOrder(OrderSearchDTO orderSearchDTO) {
		return  bsnOrderMapper.getCountOfBhfOrder(orderSearchDTO);
	}

	//발주요청 상세조회
	@Override
	public List<BhfOrderDetailDTO> getBhfOrderDetail(BhfOrderDTO bhfOrderDTO) {
		return bsnOrderMapper.selectBhfOrderDetail(bhfOrderDTO);
	}

	//발주요청 상세 페이징용 전체 수 구하기
	@Override
	public int getCountOfBhfOrderDetail(BhfOrderDTO bhfOrderDTO) {
		return bsnOrderMapper.getCountOfBhfOrderDetail(bhfOrderDTO);
	}

	//주문등록
	@Override
	public void registerOrder(BsnOrderDTO bsnOrderDTO) {
		bsnOrderMapper.insertBsnOrder(bsnOrderDTO);
		
	}
	//발주요청 취소
	@Override
	public void cancelBhfOrder(BhfOrderDTO bhfOrderDTO) {
		bsnOrderMapper.updateCancelBhfOrder(bhfOrderDTO);
		
	}
	
	//주문 조회
	@Override
	public List<BsnOrderDTO> getBsnOrder(OrderSearchDTO orderSearchDTO) {
		return bsnOrderMapper.selectBsnOrder(orderSearchDTO);
	}
	//주문 수
	@Override
	public int getCountOfBsnOrder(OrderSearchDTO orderSearchDTO) {
		return bsnOrderMapper.getCountOfBsnOrder(orderSearchDTO);
	}
	@Override
	public List<BsnOrderDetailDTO> getBsnOrderDetail(BsnOrderDTO bsnOrderDTO) {
		return bsnOrderMapper.selectBsnOrderDetail(bsnOrderDTO);
	}
	@Override
	public int getCountOfBsnOrderDetail(BsnOrderDTO bsnOrderDTO) {
		return bsnOrderMapper.getCountOfBsnOrderDetail(bsnOrderDTO);
	}
	
	@Override
	public List<BsnOrderDTO> getBsnDelivery(OrderSearchDTO orderSearchDTO) {
		return bsnOrderMapper.selectBsnDelivery(orderSearchDTO);
	}
	
	
	//(임시) 상품 재고 LOT별 조회
	@Override
	public List<BsnGoodsLOTDTO> getGoodsWarehouseLot(BsnOrderDetailDTO bsnOrderDetailDTO) {
		return bsnOrderMapper.selectGoodsWarehouseLot(bsnOrderDetailDTO);
	}
	

}
