package com.beauty1nside.accnut.service.Impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.beauty1nside.accnut.dto.DebtDTO;
import com.beauty1nside.accnut.dto.DebtSearchDTO;
import com.beauty1nside.accnut.mapper.DebtMapper;
import com.beauty1nside.accnut.service.DebtService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service	//★이거 무조건 넣어!!
//@AllArgsConstructor	//모든필드를 생성자 초기화 한다
@RequiredArgsConstructor //파이널 붙어 있는 필드만 초기화 해준다
//필드 하나뿐이면 그냥 all 하고 여러개이면 Required
public class DebtServiceImpl implements DebtService{
	
	private final DebtMapper debtMapper;
	
	@Override
	public DebtDTO info(String debtCode) {
		// TODO Auto-generated method stub
		return debtMapper.info(debtCode);
	}
	
	@Override
	public List<DebtDTO> list(DebtSearchDTO dto) {
		// TODO Auto-generated method stub
		return debtMapper.list(dto);
	}
	
	@Override
	public int count(DebtSearchDTO dto) {
		// TODO Auto-generated method stub
		return debtMapper.count(dto);
	}
}
