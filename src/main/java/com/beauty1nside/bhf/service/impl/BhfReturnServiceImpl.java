package com.beauty1nside.bhf.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beauty1nside.bhf.dto.returning.BhfGdsOptDTO;
import com.beauty1nside.bhf.dto.returning.BhfGdsOptSearchDTO;
import com.beauty1nside.bhf.dto.returning.BhfReturningVO;
import com.beauty1nside.bhf.mapper.BhfReturnMapper;
import com.beauty1nside.bhf.service.BhfReturnService;

@Service
public class BhfReturnServiceImpl implements BhfReturnService {
	
	@Autowired
	BhfReturnMapper mapper;

	@Override
	public List<BhfGdsOptDTO> goodsList(BhfGdsOptSearchDTO dto) {
		
		return mapper.goodsList(dto);
	}

	@Override
	public int count(BhfGdsOptSearchDTO dto) {
		
		return mapper.count(dto);
	}

	@Override
	public List<BhfGdsOptDTO> optionList(BhfGdsOptSearchDTO dto) {
		
		return mapper.optionList(dto);
	}

	@Override
	public void returnGoods(BhfReturningVO vo) {
		
		mapper.returnGoods(vo);
	}

}
