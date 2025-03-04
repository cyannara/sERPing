package com.beauty1nside.bhf.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beauty1nside.bhf.dto.erpboard.ErpBoardListDTO;
import com.beauty1nside.bhf.dto.erpboard.ErpBoardListSearchDTO;
import com.beauty1nside.bhf.mapper.ErpBoardMapper;
import com.beauty1nside.bhf.service.ErpBoardService;

@Service
public class ErpBoardServiceImpl implements ErpBoardService {

	@Autowired
	ErpBoardMapper mapper;

	@Override
	public List<ErpBoardListDTO> boardList(ErpBoardListSearchDTO dto) {
		
		return mapper.boardList(dto);
	}

	@Override
	public int count(ErpBoardListSearchDTO dto) {
		
		return mapper.count(dto);
	}

	@Override
	public int boardRequest(ErpBoardListDTO dto) {
		
		return mapper.boardRequest(dto);
	}

	@Override
	public boolean boardModify(ErpBoardListDTO dto) {
		
		return mapper.boardModify(dto) > 0;
	}

	@Override
	public boolean boardDelete(int boardId) {
		
		return mapper.boardDelete(boardId) > 0;
	}
	
}
