package com.beauty1nside.bsn.mapper;

import java.util.List;

import com.beauty1nside.bhf.dto.returninglist.BhfReturnListDTO;
import com.beauty1nside.bhf.dto.returninglist.BhfReturnListSearchDTO;
import com.beauty1nside.bsn.dto.cs.BsnReturnListDTO;
import com.beauty1nside.bsn.dto.cs.BsnReturningRefusalDTO;
import com.beauty1nside.bsn.dto.cs.BsnReturningRegistDTO;

public interface BsnCsMapper {
	//CS 반품/교환 요청 조회
	List<BhfReturnListDTO> selectBhfReturningList(BhfReturnListSearchDTO bhfReturnListSearchDTO);
	
	//요청조회 카운팅
	int countBhfReturningList(BhfReturnListSearchDTO bhfReturnListSearchDTO);
	
	//요청 상세 조회
	List<BsnReturnListDTO> selectBhfReturningDetail(BhfReturnListSearchDTO bhfReturnListSearchDTO);
	
	//반품요청 승인 처리
	void insertBsnCSReturningGoods(BsnReturningRegistDTO bsnReturningRegistDTO);
	
	//반품요청 거부처리
	void cancelBsnCSReturningGoods(BsnReturningRefusalDTO bsnReturningRefusalDTO);
}
