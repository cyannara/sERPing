package com.beauty1nside.bhf.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beauty1nside.bhf.dto.inventory.BhfInventoryInsertDTO;
import com.beauty1nside.bhf.dto.inventory.BhfInventoryListSearchDTO;
import com.beauty1nside.bhf.mapper.BhfInventoryListMapper;
import com.beauty1nside.bhf.service.BhfInventoryListService;

@Service
public class BhfInventoryListServiceImpl implements BhfInventoryListService {

	@Autowired
	BhfInventoryListMapper mapper;

	@Override
	public List<BhfInventoryInsertDTO> invenHistory(BhfInventoryListSearchDTO dto) {
		
		return mapper.invenHistory(dto);
	}

	@Override
	public int count(BhfInventoryListSearchDTO dto) {
		
		return mapper.count(dto);
	}
	

}
