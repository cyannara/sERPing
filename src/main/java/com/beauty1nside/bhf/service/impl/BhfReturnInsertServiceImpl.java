package com.beauty1nside.bhf.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beauty1nside.bhf.dto.returnInsert.BhfBarcodeDTO;
import com.beauty1nside.bhf.dto.returnInsert.BhfBarcodeSearchDTO;
import com.beauty1nside.bhf.mapper.BhfReturnInsertMapper;
import com.beauty1nside.bhf.service.BhfReturnInsertService;

@Service
public class BhfReturnInsertServiceImpl implements BhfReturnInsertService {

	@Autowired
	BhfReturnInsertMapper mapper;
	
	@Override
	public List<BhfBarcodeDTO> barcodeSearch(BhfBarcodeSearchDTO dto) {
		
		return mapper.barcodeSearch(dto);
	}

	@Override
	public int count(BhfBarcodeSearchDTO dto) {
		
		return mapper.count(dto);
	}

}
