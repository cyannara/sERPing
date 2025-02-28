package com.beauty1nside.bhf.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beauty1nside.bhf.dto.inventory.BhfInventoryInsertDTO;
import com.beauty1nside.bhf.dto.inventory.BhfInventoryListDTO;
import com.beauty1nside.bhf.dto.inventory.BhfInventoryListSearchDTO;
import com.beauty1nside.bhf.mapper.BhfInventoryMapper;
import com.beauty1nside.bhf.service.BhfInventoryService;

@Service
public class BhfInventoryServiceImpl implements BhfInventoryService {
	
	@Autowired
	BhfInventoryMapper mapper;

	@Override
	public List<BhfInventoryListDTO> warehouseList(BhfInventoryListSearchDTO dto) {
		
		return mapper.warehouseList(dto);
	}

	@Override
	public int count(BhfInventoryListSearchDTO dto) {
		
		return mapper.count(dto);
	}

	@Override
	public boolean mediationInsert(BhfInventoryInsertDTO dto) {
		
		// 조정 등록 메퍼
		int insertResult = mapper.mediationInsert(dto);
		// 창고 수량 뺴기 메퍼
		int updateResult = mapper.quantityUpdate(dto);
		// 창고 수량 더하기 매퍼
		int updatePlus = mapper.quantityPlus(dto);
		
		System.out.println(dto);
		
		// 삼항연산자로 두개의 결과 다 0보다 크면 true
		return (insertResult > 0 && updateResult > 0 && updatePlus > 0) ? true : false;
	}

}
