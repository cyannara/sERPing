package com.beauty1nside.bhf.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beauty1nside.bhf.dto.closing.BhfCloseVO;
import com.beauty1nside.bhf.mapper.BhfClosingMapper;
import com.beauty1nside.bhf.service.BhfClosingService;

@Service
public class BhfClosingServiceImpl implements BhfClosingService {
	
	@Autowired
	BhfClosingMapper mapper;

	@Override
	public void bhf_close(BhfCloseVO vo) {
		
		mapper.bhf_close(vo);
	}

}
