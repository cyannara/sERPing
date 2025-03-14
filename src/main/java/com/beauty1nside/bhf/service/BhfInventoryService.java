package com.beauty1nside.bhf.service;

import java.util.List;

import com.beauty1nside.bhf.dto.inventory.BhfInventoryInsertDTO;
import com.beauty1nside.bhf.dto.inventory.BhfInventoryListDTO;
import com.beauty1nside.bhf.dto.inventory.BhfInventoryListSearchDTO;

public interface BhfInventoryService {
	
	boolean mediationInsert(BhfInventoryInsertDTO dto);

	List<BhfInventoryListDTO> warehouseList(BhfInventoryListSearchDTO dto);
    
    int count(BhfInventoryListSearchDTO dto);
	
}
