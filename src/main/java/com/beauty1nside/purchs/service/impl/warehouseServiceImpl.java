package com.beauty1nside.purchs.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.beauty1nside.purchs.dto.WarehouseDTO;
import com.beauty1nside.purchs.dto.WarehouseInsertVO;
import com.beauty1nside.purchs.dto.WarehouseSearchDTO;
import com.beauty1nside.purchs.mapper.warehouseMapper;
import com.beauty1nside.purchs.service.warehouseService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2	//log4j 가 안되면 버전높은 log4j2 사용
@Service //★이거 무조건 넣어!!
@RequiredArgsConstructor
//@AllArgsConstructor	//모든필드를 생성자 초기화 한다
//필드 하나뿐이면 그냥 all 하고 여러개이면 Required
public class warehouseServiceImpl implements warehouseService{
	private final warehouseMapper warehouseMapper;

	@Override
	@Transactional
	public void warehouseInsert(List<WarehouseInsertVO> volist) {
		//리스트 내 각 그룹에 대해 프로시저 호출
		for(WarehouseInsertVO vo : volist) {
			warehouseMapper.warehouseInsert(vo);
		}
		
	}

	@Override
	public List<WarehouseDTO> getWarehouselist(WarehouseSearchDTO dto) {
		return warehouseMapper.warehouselist(dto);
	}

	@Override
	public int warehouseCount(WarehouseSearchDTO dto) {
		return warehouseMapper.warehouseCount(dto);
	}
}
