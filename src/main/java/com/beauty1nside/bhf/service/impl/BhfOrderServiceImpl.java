package com.beauty1nside.bhf.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beauty1nside.bhf.dto.BhfOrdVO;
import com.beauty1nside.bhf.mapper.BhfOrderMapper;
import com.beauty1nside.bhf.service.BhfOrderService;

@Service
public class BhfOrderServiceImpl implements BhfOrderService {
	
	@Autowired
	private BhfOrderMapper mapper;

	@Override
	public void orderPrd(BhfOrdVO vo) {
		
		mapper.orderPrd(vo);
	}

}
