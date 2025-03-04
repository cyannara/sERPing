package com.beauty1nside.bsn.service.impl;

import java.util.List;


import org.springframework.stereotype.Service;

import com.beauty1nside.bsn.dto.BsnGoodsLOTDTO;
import com.beauty1nside.bsn.dto.OrderSearchDTO;
import com.beauty1nside.bsn.dto.delivery.BsnDeliveryDTO;
import com.beauty1nside.bsn.dto.delivery.BsnDeliveryDetailDTO;
import com.beauty1nside.bsn.dto.delivery.BsnDeliveryLotDTO;
import com.beauty1nside.bsn.dto.delivery.BsnDeliverySearchDTO;
import com.beauty1nside.bsn.dto.order.BhfOrderDTO;
import com.beauty1nside.bsn.dto.order.BhfOrderDetailDTO;
import com.beauty1nside.bsn.dto.order.BsnOrderCancelDTO;
import com.beauty1nside.bsn.dto.order.BsnOrderDTO;
import com.beauty1nside.bsn.dto.order.BsnOrderDetailDTO;
import com.beauty1nside.bsn.mapper.BsnOrderMapper;
import com.beauty1nside.bsn.service.BsnCustomException;
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
	//주문 취소
	@Override
	public void cancelBsnOrder(BsnOrderCancelDTO bsnOrderCancelDTO) {
		bsnOrderMapper.cancelBsnOrder(bsnOrderCancelDTO);	
	}
	
	//출고 조회(출고처리페이지)
	@Override
	public List<BsnDeliveryDTO> getBsnDelivery(BsnDeliverySearchDTO bsnDeliverySearchDTO) {
		return bsnOrderMapper.selectBsnDelivery(bsnDeliverySearchDTO);
	}
	//출고 카운팅(출고처리페이지)
	@Override
	public int getCountOfBsnDelivery(BsnDeliverySearchDTO bsnDeliverySearchDTO) {
		return bsnOrderMapper.getCountBsnDelivery(bsnDeliverySearchDTO);
	}
	
	//출고 상세(출고처리페이지)
	@Override
	public List<BsnDeliveryDetailDTO> getBsnDeliveryDetail(BsnDeliveryDTO bsnDeliveryDTO) {
		return bsnOrderMapper.selectBsnDeliveryDetail(bsnDeliveryDTO);
	}
	//출고 상세 카운팅(출고처리페이지)
	@Override
	public int getCountOfBsnDeliveryDetail(BsnDeliveryDTO bsnDeliveryDTO) {
		return bsnOrderMapper.getCountBsnDeliveryDetail(bsnDeliveryDTO);
	}
	
	
	//출고 LOT 상세(출고처리페이지)
	@Override
	public List<BsnDeliveryLotDTO> getBsnDeliveryLotDetail(BsnDeliveryDetailDTO bsnDeliveryDetailDTO) {
		return bsnOrderMapper.selectBsnDeliveryLotDetail(bsnDeliveryDetailDTO);
	}
	
	//출고 LOT 상세 카운팅
	@Override
	public int getCountOfBsnDeliveryLotDetail(BsnDeliveryDetailDTO bsnDeliveryDetailDTO) {
		return bsnOrderMapper.getCountBsnDeliveryLotDetail(bsnDeliveryDetailDTO);
	}
	
	//상품 재고 LOT별 조회(출고처리페이지)
	@Override
	public List<BsnGoodsLOTDTO> getGoodsWarehouseLot(BsnDeliveryDetailDTO bsnDeliveryDetailDTO) {
		return bsnOrderMapper.selectGoodsWarehouseLot(bsnDeliveryDetailDTO);
	}
	//상품 재고 LOT별 조회 카운팅(출고처리페이지)
	@Override
	public int getCountOfGoodsWarehouseLot(BsnDeliveryDetailDTO bsnDeliveryDetailDTO) {
		return bsnOrderMapper.getCountGoodsWarehouseLot(bsnDeliveryDetailDTO);
	}
	
	//출고 LOT 등록
	@Override
	public void registerBsnDeliveryLotDetail(BsnDeliveryDetailDTO bsnDeliveryDetailDTO) {
		bsnOrderMapper.insertBsnDeliveryLotDetail(bsnDeliveryDetailDTO);
	}
	//촐고 LOT 수량 수정
	@Override
	public void modifyBsnDeliveryLotDetail(BsnDeliveryDetailDTO bsnDeliveryDetailDTO) {
		bsnOrderMapper.updateBsnDeliveryLotDetail(bsnDeliveryDetailDTO);
		
	}
	
	//출고 LOT 삭제
	@Override
	public void removeBsnDeliveryLotDetail(BsnDeliveryDetailDTO bsnDeliveryDetailDTO) {
		bsnOrderMapper.deleteBsnDeliveryLotDetail(bsnDeliveryDetailDTO);
		
	}
	
	//출고 완료
	@Override
	public void completeBsnDelivery(BsnDeliveryDTO bsnDeliveryDTO) {
		try {
	        bsnOrderMapper.confirmBsnDelivery(bsnDeliveryDTO.getDeliveryId());
	    } catch (BsnCustomException e) {
	        // MyBatis 예외 처리
	    	if (e.getErrorCode() == -20001) {
	            throw new BsnCustomException(e.getErrorCode(), "출고 가능한 수량이 부족합니다.");
	        } else if (e.getErrorCode() == -20002) {
	            throw new BsnCustomException(e.getErrorCode(), "창고 재고 데이터가 없습니다.");
	        } else if (e.getErrorCode() == -20003) {
	            throw new BsnCustomException(e.getErrorCode(), "출고 확정 중 오류 발생: " + e.getErrorMessage());
	        } else if (e.getErrorCode() == -20004) {
	            throw new BsnCustomException(e.getErrorCode(), "배송 데이터가 없습니다.");
	        } else if (e.getErrorCode() == -20005) {
	            throw new BsnCustomException(e.getErrorCode(), "주문 데이터가 없습니다.");
	        } else {
	            throw new BsnCustomException(-99999, "알 수 없는 오류 발생");
	        }
	    }
	 }
	
	
	
	
	
	
	
	

}
