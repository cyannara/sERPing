package com.beauty1nside.purchs.service;

import java.util.List;

import com.beauty1nside.purchs.dto.WarehouseInsertVO;

public interface warehouseService {
	//발주서등록 
	public void warehouseInsert(List<WarehouseInsertVO> volist);
}
