package com.beauty1nside.accnut.service.Impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.beauty1nside.accnut.dto.IncidentalCostDTO;
import com.beauty1nside.accnut.dto.IncidentalCostSearchDTO;
import com.beauty1nside.accnut.mapper.IncidentalCostMapper;
import com.beauty1nside.accnut.mapper.SalaryBookMapper;
import com.beauty1nside.accnut.service.IncidentalCostService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service	//★이거 무조건 넣어!!
//@AllArgsConstructor	//모든필드를 생성자 초기화 한다
@RequiredArgsConstructor //파이널 붙어 있는 필드만 초기화 해준다
//필드 하나뿐이면 그냥 all 하고 여러개이면 Required
public class IncidentalCostServiceImpl implements IncidentalCostService{

	final IncidentalCostMapper incidentalCostMapper;
	
	@Override
	public IncidentalCostDTO info(String incidentalCostCode) {
		// TODO Auto-generated method stub
		return incidentalCostMapper.info(incidentalCostCode);
	}
	
	@Override
	public List<IncidentalCostDTO> list(IncidentalCostSearchDTO dto) {
		// TODO Auto-generated method stub
		return incidentalCostMapper.list(dto);
	}
	
	@Override
	public int count(IncidentalCostSearchDTO dto) {
		// TODO Auto-generated method stub
		return incidentalCostMapper.count(dto);
	}
	
}
