package com.beauty1nside.hr.service;

import java.util.List;

import com.beauty1nside.hr.dto.EmpDTO;
import com.beauty1nside.hr.dto.EmpSearchDTO;


public interface EmpService {
	EmpDTO info(Long employeeNum);
	List<EmpDTO> list(EmpSearchDTO dto);
	int count(EmpSearchDTO dto);
}