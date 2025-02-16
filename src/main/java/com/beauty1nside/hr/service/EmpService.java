package com.beauty1nside.hr.service;

import java.util.List;
import java.util.Map;

import com.beauty1nside.hr.dto.EmpDTO;
import com.beauty1nside.hr.dto.EmpSearchDTO;


public interface EmpService {
	
	// 사원 단건조회
	EmpDTO info(Long employeeNum);
	
	// 사원 전체조회
	List<EmpDTO> list(EmpSearchDTO dto);
	
	//사원 조회 페이지 건수
	int count(EmpSearchDTO dto);
	
	//공통코드 가져오기
	Map<String, Object> getCommonCodes();
}