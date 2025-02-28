package com.beauty1nside.purchs.service;

import java.util.List;

import com.beauty1nside.purchs.dto.WarehouseDTO;
import com.beauty1nside.purchs.dto.WarehouseInsertVO;
import com.beauty1nside.purchs.dto.WarehouseSearchDTO;

public interface warehouseService {
	//구매등록 
	public void warehouseInsert(List<WarehouseInsertVO> volist);
	
	//구매 조회
	public List<WarehouseDTO> getWarehouselist(WarehouseSearchDTO dto);
	int warehouseCount(WarehouseSearchDTO dto);
}
