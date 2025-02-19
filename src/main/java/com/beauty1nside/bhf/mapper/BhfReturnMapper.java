package com.beauty1nside.bhf.mapper;

import java.util.List;

import com.beauty1nside.bhf.dto.returning.BhfGdsOptDTO;
import com.beauty1nside.bhf.dto.returning.BhfGdsOptSearchDTO;

public interface BhfReturnMapper {

	//창고 상품 조회
	public List<BhfGdsOptDTO> goodsList(BhfGdsOptSearchDTO dto);
	
	//페이징 할떄 조회되는 전체값
	int count(BhfGdsOptSearchDTO dto);
	
	//옵션 조회
	public List<BhfGdsOptDTO> optionList(BhfGdsOptSearchDTO dto);
	
}
