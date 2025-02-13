package com.beauty1nside.accnut.mapper;

import java.util.List;

import com.beauty1nside.accnut.dto.DealBookDTO;
import com.beauty1nside.accnut.dto.DealBookSearchDTO;

public interface DealBookMapper {
	DealBookDTO info(String dealingsAccountBookCode);
	List<DealBookDTO> list(DealBookSearchDTO dto);
	int count(DealBookSearchDTO dto);
}
