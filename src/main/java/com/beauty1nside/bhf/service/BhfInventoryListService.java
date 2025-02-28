package com.beauty1nside.bhf.service;

import java.util.List;

import com.beauty1nside.bhf.dto.inventory.BhfInventoryInsertDTO;
import com.beauty1nside.bhf.dto.inventory.BhfInventoryListSearchDTO;

public interface BhfInventoryListService {

	List<BhfInventoryInsertDTO> invenHistory(BhfInventoryListSearchDTO dto);

    int count(BhfInventoryListSearchDTO dto);
	
}
