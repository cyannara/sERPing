package com.beauty1nside.bhf.mapper;

import java.util.List;

import com.beauty1nside.bhf.dto.inventory.BhfInventoryInsertDTO;
import com.beauty1nside.bhf.dto.inventory.BhfInventoryListDTO;
import com.beauty1nside.bhf.dto.inventory.BhfInventoryListSearchDTO;

public interface BhfInventoryMapper {
	
	// 조정 등록
	int mediationInsert(BhfInventoryInsertDTO dto);
	// 조정 등록 후 창고 수량뺴기
	int quantityUpdate(BhfInventoryInsertDTO dto);
	// 조정 등록 후 창고 수량더하기
	int quantityPlus(BhfInventoryInsertDTO dto);
	
	// 조정 내역 조회
	List<BhfInventoryInsertDTO> invenHistory(BhfInventoryListSearchDTO dto);
	
	// 창고 재고 조회
    List<BhfInventoryListDTO> warehouseList(BhfInventoryListSearchDTO dto);
    
    // 페이징 카운트
    int count(BhfInventoryListSearchDTO dto);
	
}
