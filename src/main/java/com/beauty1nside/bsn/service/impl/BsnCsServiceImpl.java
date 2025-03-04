package com.beauty1nside.bsn.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.beauty1nside.bhf.dto.returninglist.BhfReturnListDTO;
import com.beauty1nside.bhf.dto.returninglist.BhfReturnListSearchDTO;
import com.beauty1nside.bsn.dto.cs.BsnCsReturningDetailDTO;
import com.beauty1nside.bsn.dto.cs.BsnReturnListDTO;
import com.beauty1nside.bsn.dto.cs.BsnReturningRefusalDTO;
import com.beauty1nside.bsn.dto.cs.BsnReturningRegistDTO;
import com.beauty1nside.bsn.mapper.BsnCsMapper;
import com.beauty1nside.bsn.service.BsnCsService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BsnCsServiceImpl implements BsnCsService{

	final BsnCsMapper bsnCsMapper;
	
	@Override
	public List<BhfReturnListDTO> bhfReturningList(BhfReturnListSearchDTO dto) {
		return bsnCsMapper.selectBhfReturningList(dto);
	}

	@Override
	public int countBhfReturningList(BhfReturnListSearchDTO dto) {
		return bsnCsMapper.countBhfReturningList(dto);
	}

	@Override
	public List<BsnReturnListDTO> bhfReturningDetail(BhfReturnListSearchDTO dto) {
		return bsnCsMapper.selectBhfReturningDetail(dto);
	}
	
	@Override
	public List<BsnCsReturningDetailDTO> getBsnCsReturningDetail(BhfReturnListSearchDTO dto) {
		return bsnCsMapper.selectBsnCsReturningDetail(dto);
	}
	
	@Override
	public int getCountOfBsnCsReturningDetail(BhfReturnListSearchDTO dto) {
		return bsnCsMapper.countBsnCsReturningDetail(dto);
	}

	//반품 교환 처리
	@Override
	public void registBsnReturning(BsnReturningRegistDTO bsnReturningRegistDTO) {
		bsnCsMapper.insertBsnCSReturningGoods(bsnReturningRegistDTO);
		
	}

	@Override
	public void cancleBsnReturning(BsnReturningRefusalDTO bsnReturningRefusalDTO) {
		bsnCsMapper.cancelBsnCSReturningGoods(bsnReturningRefusalDTO);
		
	}

	

	

}
