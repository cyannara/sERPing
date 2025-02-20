package com.beauty1nside.accnut.service;

import java.util.List;

import com.beauty1nside.accnut.dto.DealBookDTO;
import com.beauty1nside.accnut.dto.DealBookSearchDTO;

public interface DealBookService {
	
	DealBookDTO info(String dealingsAccountBookCode);
	List<DealBookDTO> list(DealBookSearchDTO dto);
	int count(DealBookSearchDTO dto);
	int insert(DealBookDTO dto);
}
