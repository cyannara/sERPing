package com.beauty1nside.bhf.service;

import java.util.List;

import com.beauty1nside.bhf.dto.returninglist.BhfReturnListDTO;
import com.beauty1nside.bhf.dto.returninglist.BhfReturnListSearchDTO;

public interface BhfReturnListService {

	public List<BhfReturnListDTO> returnList(BhfReturnListSearchDTO dto);
	
	public List<BhfReturnListDTO> returnDetailList(BhfReturnListSearchDTO dto);

	int count(BhfReturnListSearchDTO dto);
	
}
