package com.beauty1nside.bhf.mapper;

import java.util.List;

import com.beauty1nside.bhf.dto.inventory.BhfInventoryInsertDTO;
import com.beauty1nside.bhf.dto.inventory.BhfInventoryListSearchDTO;

public interface BhfInventoryListMapper {

	// 조정 내역 조회
	List<BhfInventoryInsertDTO> invenHistory(BhfInventoryListSearchDTO dto);

    // 페이징 카운트
    int count(BhfInventoryListSearchDTO dto);
    
}
