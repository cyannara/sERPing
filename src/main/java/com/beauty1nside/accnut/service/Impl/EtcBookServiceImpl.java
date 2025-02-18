package com.beauty1nside.accnut.service.Impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.beauty1nside.accnut.dto.EtcBookDTO;
import com.beauty1nside.accnut.dto.EtcBookSearchDTO;
import com.beauty1nside.accnut.mapper.EtcBookMapper;
import com.beauty1nside.accnut.service.EtcBookService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service	//★이거 무조건 넣어!!
//@AllArgsConstructor	//모든필드를 생성자 초기화 한다
@RequiredArgsConstructor //파이널 붙어 있는 필드만 초기화 해준다
//필드 하나뿐이면 그냥 all 하고 여러개이면 Required
public class EtcBookServiceImpl implements EtcBookService{
	
	final EtcBookMapper etcBookMapper;
	
	@Override
	public EtcBookDTO info(String etcPaymentCode) {
		// TODO Auto-generated method stub
		return etcBookMapper.info(etcPaymentCode);
	}
	
	@Override
	public List<EtcBookDTO> list(EtcBookSearchDTO dto) {
		// TODO Auto-generated method stub
		return etcBookMapper.list(dto);
	}
	
	@Override
	public int count(EtcBookSearchDTO dto) {
		// TODO Auto-generated method stub
		return etcBookMapper.count(dto);
	}
}
