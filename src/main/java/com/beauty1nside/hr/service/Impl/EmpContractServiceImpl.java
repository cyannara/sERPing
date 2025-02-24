package com.beauty1nside.hr.service.Impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.beauty1nside.hr.dto.EmpContractDTO;
import com.beauty1nside.hr.dto.EmpContractSearchDTO;
import com.beauty1nside.hr.mapper.EmpContractMapper;
import com.beauty1nside.hr.service.EmpContractService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service // ★이거 무조건 넣어!!
//@AllArgsConstructor	//모든필드를 생성자 초기화 한다
@RequiredArgsConstructor // 파이널 붙어 있는 필드만 초기화 해준다
//필드 하나뿐이면 그냥 all 하고 여러개이면 Required
public class EmpContractServiceImpl implements EmpContractService {

	private final EmpContractMapper empContractMapper;

	@Override
	public void insertContract(EmpContractDTO dto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<EmpContractDTO> getContracts(EmpContractSearchDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EmpContractDTO info(Long contractNum) {
		// TODO Auto-generated method stub
		return null;
	}

    
    





}
