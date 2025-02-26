package com.beauty1nside.hr.service.Impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.beauty1nside.hr.dto.EmpContractDTO;
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

    // 근로계약 등록 (트랜잭션 적용)
    @Override
    @Transactional
    public int registerContract(EmpContractDTO contract) {
        return empContractMapper.insertContract(contract);
    }

    // 특정 사원의 최근 계약 조회
    @Override
    public EmpContractDTO getLastContract(Long employeeNum) {
        return empContractMapper.getLastContract(employeeNum);
    }

    // 전체 계약 목록 조회
    @Override
    public List<EmpContractDTO> getAllContracts() {
        return empContractMapper.getAllContracts();
    }


}
