package com.beauty1nside.accnut.service;

import java.util.List;

import com.beauty1nside.accnut.dto.SellingDTO;
import com.beauty1nside.accnut.dto.SellingSearchDTO;

public interface SellingService {
	List<SellingDTO> info(SellingSearchDTO dto);
	int infoCount(SellingSearchDTO dto);
	List<SellingDTO> list(SellingSearchDTO dto);
	int listCount(SellingSearchDTO dto);
}
