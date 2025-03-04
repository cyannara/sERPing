package com.beauty1nside.bhf.mapper;

import java.util.List;

import com.beauty1nside.bhf.dto.erpboard.ErpBoardListDTO;
import com.beauty1nside.bhf.dto.erpboard.ErpBoardListSearchDTO;

public interface ErpBoardMapper {

	public List<ErpBoardListDTO> boardList(ErpBoardListSearchDTO dto);
	public int count(ErpBoardListSearchDTO dto);
	
	public int boardRequest(ErpBoardListDTO dto);
	
	public int boardModify(ErpBoardListDTO dto);
	
	public int boardDelete(int boardId);
	
}
