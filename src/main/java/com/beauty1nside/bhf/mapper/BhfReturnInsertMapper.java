package com.beauty1nside.bhf.mapper;

import java.util.List;

import com.beauty1nside.bhf.dto.returnInsert.BhfBarcodeDTO;
import com.beauty1nside.bhf.dto.returnInsert.BhfBarcodeSearchDTO;
import com.beauty1nside.bhf.dto.returnInsert.BhfReturnInsertVO;

public interface BhfReturnInsertMapper {
	
	public void returnGoods(BhfReturnInsertVO vo);

	// 바코드 입력시 나오는 조회
	public List<BhfBarcodeDTO> barcodeSearch(BhfBarcodeSearchDTO dto);
	// 페이징 전체 값
	int count(BhfBarcodeSearchDTO dto);
	
}
