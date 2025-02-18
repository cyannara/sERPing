package com.beauty1nside.bhf.service;

import java.util.List;

import com.beauty1nside.bhf.dto.returning.BhfGdsOptDTO;
import com.beauty1nside.bhf.dto.returning.BhfGdsOptSearchDTO;

public interface BhfReturnService {

	public List<BhfGdsOptDTO> goodsList(BhfGdsOptSearchDTO dto);
	
	int count(BhfGdsOptSearchDTO dto);
	
	public List<BhfGdsOptDTO> optionList(BhfGdsOptSearchDTO dto);
	
}
