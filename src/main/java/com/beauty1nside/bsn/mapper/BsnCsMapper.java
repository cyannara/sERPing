package com.beauty1nside.bsn.mapper;

import java.util.List;

import com.beauty1nside.bhf.dto.returninglist.BhfReturnListDTO;
import com.beauty1nside.bhf.dto.returninglist.BhfReturnListSearchDTO;
import com.beauty1nside.bsn.dto.cs.BsnReturnListDTO;

public interface BsnCsMapper {
	//CS 반품/교환 요청 조회
	List<BhfReturnListDTO> selectBhfReturningList(BhfReturnListSearchDTO bhfReturnListSearchDTO);
	
	//요청조회 카운팅
	int countBhfReturningList(BhfReturnListSearchDTO bhfReturnListSearchDTO);
	
	//요청 상세 조회
	List<BsnReturnListDTO> selectBhfReturningDetail(BhfReturnListSearchDTO bhfReturnListSearchDTO);
}
