package com.beauty1nside.bsn.mapper;

import java.util.List;

import com.beauty1nside.bsn.dto.BhfOrderDTO;
import com.beauty1nside.bsn.dto.OrderSearchDTO;

public interface BsnOrderMapper {
	
	// 발주신청 조회
	List<BhfOrderDTO> selectBhfOrder(OrderSearchDTO orderSearchDTO);
	
	//발주신청건수 확인
	int getCountOfBhfOrder(OrderSearchDTO orderSearchDTO);
}
