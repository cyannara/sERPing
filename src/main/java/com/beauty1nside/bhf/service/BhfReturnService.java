package com.beauty1nside.bhf.service;

import java.util.List;

import com.beauty1nside.bhf.dto.returning.BhfGdsOptDTO;
import com.beauty1nside.bhf.dto.returning.BhfGdsOptSearchDTO;
import com.beauty1nside.bhf.dto.returning.BhfReturningVO;

public interface BhfReturnService {
	
	public void returnGoods(BhfReturningVO vo);

	public List<BhfGdsOptDTO> goodsList(BhfGdsOptSearchDTO dto);
	
	int count(BhfGdsOptSearchDTO dto);
	
	public List<BhfGdsOptDTO> optionList(BhfGdsOptSearchDTO dto);
	
}
