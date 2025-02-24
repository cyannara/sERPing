package com.beauty1nside.bhf.service;

import java.util.List;

import com.beauty1nside.bhf.dto.returnInsert.BhfBarcodeDTO;
import com.beauty1nside.bhf.dto.returnInsert.BhfBarcodeSearchDTO;

public interface BhfReturnInsertService {

	public List<BhfBarcodeDTO> barcodeSearch(BhfBarcodeSearchDTO dto);
	
	int count(BhfBarcodeSearchDTO dto);
	
}
