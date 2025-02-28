package com.beauty1nside.accnut.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.beauty1nside.accnut.dto.SellingDTO;
import com.beauty1nside.accnut.dto.SellingSearchDTO;
import com.beauty1nside.accnut.mapper.OtherMapper;
import com.beauty1nside.accnut.mapper.SellingMapper;
import com.beauty1nside.accnut.service.SellingService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service	//★이거 무조건 넣어!!
//@AllArgsConstructor	//모든필드를 생성자 초기화 한다
@RequiredArgsConstructor //파이널 붙어 있는 필드만 초기화 해준다
//필드 하나뿐이면 그냥 all 하고 여러개이면 Required
public class SellingServiceImpl implements SellingService{
	
	final SellingMapper sellingMapper;
	final OtherMapper otherMapper;
	
	@Override
	public List<SellingDTO> info(SellingSearchDTO dto) {
		// TODO Auto-generated method stub
		List<SellingDTO> result = sellingMapper.info(dto);
		
		result.forEach(sell -> {
			String day = sell.getResultDate();
			String start = day.substring(0, 10);
			String end = day.substring(11);
			log.info(end);
		});
		
		return result;
	}
	
	@Override
	public int infoCount(SellingSearchDTO dto) {
		// TODO Auto-generated method stub
		return sellingMapper.infoCount(dto);
	}
	
	@Override
	public List<SellingDTO> list(SellingSearchDTO dto) {
		// TODO Auto-generated method stub
		List<SellingDTO> result = sellingMapper.list(dto);
		
		return result;
	}
	
	@Override
	public int listCount(SellingSearchDTO dto) {
		// TODO Auto-generated method stub
		return sellingMapper.listCount(dto);
	}
}
