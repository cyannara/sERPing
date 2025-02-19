package com.beauty1nside.bhf.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beauty1nside.bhf.dto.returninglist.BhfReturnListDTO;
import com.beauty1nside.bhf.dto.returninglist.BhfReturnListSearchDTO;
import com.beauty1nside.bhf.mapper.BhfReturnListMapper;
import com.beauty1nside.bhf.service.BhfReturnListService;

@Service
public class BhfReturnListServiceImpl implements BhfReturnListService {
	
	@Autowired
	BhfReturnListMapper mapper;

	@Override
	public List<BhfReturnListDTO> returnList(BhfReturnListSearchDTO dto) {
		
		return mapper.returnList(dto);
	}

	@Override
	public List<BhfReturnListDTO> returnDetailList(BhfReturnListSearchDTO dto) {
		
		return mapper.returnDetailList(dto);
	}

	@Override
	public int count(BhfReturnListSearchDTO dto) {
		
		return mapper.count(dto);
	}

}
