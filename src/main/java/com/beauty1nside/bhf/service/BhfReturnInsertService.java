package com.beauty1nside.bhf.service;

import java.util.List;

import com.beauty1nside.bhf.dto.returnInsert.BhfBarcodeDTO;
import com.beauty1nside.bhf.dto.returnInsert.BhfBarcodeSearchDTO;
import com.beauty1nside.bhf.dto.returnInsert.BhfReturnInsertVO;

public interface BhfReturnInsertService {
	
	public void returnGoods(BhfReturnInsertVO vo);

	public List<BhfBarcodeDTO> barcodeSearch(BhfBarcodeSearchDTO dto);
	
	int count(BhfBarcodeSearchDTO dto);
	
}
