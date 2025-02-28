package com.beauty1nside.purchs.mapper;

import java.util.List;

import com.beauty1nside.purchs.dto.WarehouseDTO;
import com.beauty1nside.purchs.dto.WarehouseInsertVO;
import com.beauty1nside.purchs.dto.WarehouseSearchDTO;

public interface warehouseMapper {
	//구매등록
	public void warehouseInsert(WarehouseInsertVO vo);
	
	//구매 조회 
	List<WarehouseDTO>warehouselist(WarehouseSearchDTO dto);
	int warehouseCount(WarehouseSearchDTO dto);
}
