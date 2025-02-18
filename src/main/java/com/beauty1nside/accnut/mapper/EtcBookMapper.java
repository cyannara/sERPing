package com.beauty1nside.accnut.mapper;

import java.util.List;

import com.beauty1nside.accnut.dto.EtcBookDTO;
import com.beauty1nside.accnut.dto.EtcBookSearchDTO;

public interface EtcBookMapper {
	EtcBookDTO info(String etcPaymentCode);
	List<EtcBookDTO> list(EtcBookSearchDTO dto);
	int count(EtcBookSearchDTO dto);
}
