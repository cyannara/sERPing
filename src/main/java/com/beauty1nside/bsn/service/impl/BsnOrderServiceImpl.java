package com.beauty1nside.bsn.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.beauty1nside.bsn.dto.BhfOrderDTO;
import com.beauty1nside.bsn.dto.BhfOrderDetailDTO;
import com.beauty1nside.bsn.dto.OrderSearchDTO;
import com.beauty1nside.bsn.mapper.BsnOrderMapper;
import com.beauty1nside.bsn.service.BsnOrderService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BsnOrderServiceImpl implements BsnOrderService {
	
	private final BsnOrderMapper bsnOrderMapper;

	@Override
	public List<BhfOrderDTO> getBhfOrder(OrderSearchDTO orderSearchDTO) {
		return bsnOrderMapper.selectBhfOrder(orderSearchDTO);
	}

	@Override
	public int getCountOfBhfOrder(OrderSearchDTO orderSearchDTO) {
		return  bsnOrderMapper.getCountOfBhfOrder(orderSearchDTO);
	}

	@Override
	public List<BhfOrderDetailDTO> getBhfOrderDetail(BhfOrderDTO bhfOrderDTO) {
		return bsnOrderMapper.selectBhfOrderDetail(bhfOrderDTO);
	}

	@Override
	public int getCountOfBhfOrderDetail(BhfOrderDTO bhfOrderDTO) {
		return bsnOrderMapper.getCountOfBhfOrderDetail(bhfOrderDTO);
	}

}
