package com.beauty1nside.accnut.service.Impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.beauty1nside.accnut.dto.SalaryBookDTO;
import com.beauty1nside.accnut.dto.SalaryBookSearchDTO;
import com.beauty1nside.accnut.mapper.SalaryBookMapper;
import com.beauty1nside.accnut.service.SalaryBookService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service	//★이거 무조건 넣어!!
//@AllArgsConstructor	//모든필드를 생성자 초기화 한다
@RequiredArgsConstructor //파이널 붙어 있는 필드만 초기화 해준다
//필드 하나뿐이면 그냥 all 하고 여러개이면 Required
public class SalaryBookServiceImpl implements SalaryBookService{
	
	final SalaryBookMapper salaryBookMapper;
	
	@Override
	public SalaryBookDTO info(String salaryAccountBookCode) {
		// TODO Auto-generated method stub
		return salaryBookMapper.info(salaryAccountBookCode);
	}
	
	@Override
	public List<SalaryBookDTO> list(SalaryBookSearchDTO dto) {
		// TODO Auto-generated method stub
		return salaryBookMapper.list(dto);
	}
	
	@Override
	public int count(SalaryBookSearchDTO dto) {
		// TODO Auto-generated method stub
		return salaryBookMapper.count(dto);
	}
	
	@Override
	@Transactional
	public int update(List<SalaryBookDTO> dtoList) {
		// TODO Auto-generated method stub
		int result = 0;
		for(SalaryBookDTO dto : dtoList) {
			int co = salaryBookMapper.update(dto);
			result += co;
		}
		return result;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
