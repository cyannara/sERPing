package com.beauty1nside.stdr.service.impl;

import com.beauty1nside.stdr.dto.DocumentDTO;
import com.beauty1nside.stdr.dto.DocumentSearchDTO;
import com.beauty1nside.stdr.mapper.DocumentMapper;
import com.beauty1nside.stdr.service.DocumentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
@RequiredArgsConstructor
public class DocumentServiceImpl implements DocumentService {
	
	private final DocumentMapper documentMapper;
	
	@Override
	public List<DocumentDTO> documentList(DocumentSearchDTO dto) {
		return documentMapper.documentList(dto);
	}
	
	@Override
	public int count(DocumentSearchDTO dto) {
		return documentMapper.count(dto);
	}
}
