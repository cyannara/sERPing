package com.beauty1nside.accnut.service.Impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.beauty1nside.accnut.dto.DealBookDTO;
import com.beauty1nside.accnut.dto.DealBookSearchDTO;
import com.beauty1nside.accnut.mapper.DealBookMapper;
import com.beauty1nside.accnut.service.DealBookService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service	//★이거 무조건 넣어!!
//@AllArgsConstructor	//모든필드를 생성자 초기화 한다
@RequiredArgsConstructor //파이널 붙어 있는 필드만 초기화 해준다
//필드 하나뿐이면 그냥 all 하고 여러개이면 Required
public class DealBookServiceImpl implements DealBookService{
	
	private final DealBookMapper dealBookMapper;
	
	@Override
	public DealBookDTO info(String dealingsAccountBookCode) {
		// TODO Auto-generated method stub
		return dealBookMapper.info(dealingsAccountBookCode);
	}
	
	@Override
	public List<DealBookDTO> list(DealBookSearchDTO dto) {
		// TODO Auto-generated method stub
		return dealBookMapper.list(dto);
	}
	
	@Override
	public int count(DealBookSearchDTO dto) {
		// TODO Auto-generated method stub
		return dealBookMapper.count(dto);
	}
	
	@Override
	public int insert(DealBookDTO dto) {
		// TODO Auto-generated method stub
		return dealBookMapper.insert(dto);
	}
}
