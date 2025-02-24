package com.beauty1nside.hr.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.beauty1nside.hr.dto.EmpContractDTO;
import com.beauty1nside.hr.dto.EmpContractSearchDTO;

@Mapper
public interface EmpContractMapper {
	
    // 근로 계약 목록 조회
    List<EmpContractDTO> List(EmpContractSearchDTO searchDTO);
    
    // 특정 근로 계약 조회 (단건)
    EmpContractDTO info(Long contractNum);
    
    // 근로 계약 등록
    void insertContract(EmpContractDTO contractDTO);
    
    // 근로 계약 수정
    void updateContract(EmpContractDTO contractDTO);
    
    // 근로 계약 삭제
    void deleteContract(Long contractNum);
    
    // 총 계약 수 (페이징 처리용)
    int totalCount(EmpContractSearchDTO searchDTO);
    

}
