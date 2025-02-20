package com.beauty1nside.stdr.service.impl;

import com.beauty1nside.stdr.dto.DocumentDTO;
import com.beauty1nside.stdr.mapper.StdrDeptMapper;
import com.beauty1nside.stdr.service.StdrDeptService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
@RequiredArgsConstructor
public class StdrStdrDeptServiceImpl implements StdrDeptService {
	
	private final StdrDeptMapper stdrDeptMapper;
	
	@Override
	public List<DocumentDTO> hqDeptList(DocumentDTO dto) {
		return stdrDeptMapper.hqDeptList(dto);
	}
}
