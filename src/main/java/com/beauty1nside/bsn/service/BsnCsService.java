package com.beauty1nside.bsn.service;

import java.util.List;

import com.beauty1nside.bhf.dto.returninglist.BhfReturnListDTO;
import com.beauty1nside.bhf.dto.returninglist.BhfReturnListSearchDTO;
import com.beauty1nside.bsn.dto.cs.BsnReturnListDTO;


public interface BsnCsService {
	
	//반품 주문 조회
    public List<BhfReturnListDTO> bhfReturningList(BhfReturnListSearchDTO dto);
	
	public List<BsnReturnListDTO> bhfReturningDetail(BhfReturnListSearchDTO dto);

	int countBhfReturningList(BhfReturnListSearchDTO dto);

}
