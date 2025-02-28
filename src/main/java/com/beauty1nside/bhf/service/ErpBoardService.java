package com.beauty1nside.bhf.service;

import java.util.List;

import com.beauty1nside.bhf.dto.erpboard.ErpBoardListDTO;
import com.beauty1nside.bhf.dto.erpboard.ErpBoardListSearchDTO;

public interface ErpBoardService {

	public List<ErpBoardListDTO> boardList(ErpBoardListSearchDTO dto);
	public int count(ErpBoardListSearchDTO dto);
	
}
