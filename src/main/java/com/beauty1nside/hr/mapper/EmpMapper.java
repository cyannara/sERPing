package com.beauty1nside.hr.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.beauty1nside.hr.dto.EmpDTO;
import com.beauty1nside.hr.dto.EmpSearchDTO;

@Mapper
public interface EmpMapper {
	
	EmpDTO info(Long employeeNum);
	List<EmpDTO> list(EmpSearchDTO dto);
	int count(EmpSearchDTO dto);
}
