package com.beauty1nside.bhf.mapper;

import java.util.List;

import com.beauty1nside.bhf.dto.returninglist.BhfReturnListDTO;
import com.beauty1nside.bhf.dto.returninglist.BhfReturnListSearchDTO;

public interface BhfReturnListMapper {
	
	//교환 및 반품 조회
	public List<BhfReturnListDTO> returnList(BhfReturnListSearchDTO dto);
	
	//교환 및 반품 상세 조회
	public List<BhfReturnListDTO> returnDetailList(BhfReturnListSearchDTO dto);

	//페이징 할떄 조회되는 전체값
	int count(BhfReturnListSearchDTO dto);
}
