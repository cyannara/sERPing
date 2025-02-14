package com.beauty1nside.accnut.mapper;

import java.util.List;

import com.beauty1nside.accnut.dto.DebtDTO;
import com.beauty1nside.accnut.dto.DebtSearchDTO;

public interface DebtMapper {
	DebtDTO info(String debtCode);
	List<DebtDTO> list(DebtSearchDTO dto);
	int count(DebtSearchDTO dto);
	
	
	
	
	
//	미지급금 처리 조회
	List<DebtDTO> unpayList(DebtSearchDTO dto);
	int unpayCount(DebtSearchDTO dto);
//	미지급금 처리 수정
	
}
