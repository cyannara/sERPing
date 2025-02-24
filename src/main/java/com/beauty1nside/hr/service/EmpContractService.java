package com.beauty1nside.hr.service;

import java.util.List;

import com.beauty1nside.hr.dto.EmpContractDTO;
import com.beauty1nside.hr.dto.EmpContractSearchDTO;


public interface EmpContractService {
	
    // 계약 등록
    void insertContract(EmpContractDTO dto);

    // 계약 리스트 조회
    List<EmpContractDTO> getContracts(EmpContractSearchDTO dto);

    // 계약 상세 조회
    EmpContractDTO info(Long contractNum);

}