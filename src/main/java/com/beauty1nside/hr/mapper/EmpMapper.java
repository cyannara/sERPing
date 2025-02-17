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
	
    List<String> getDepartments(); // 부서 목록
    List<String> getPositions(); // 직급 목록
    List<String> getEmploymentTypes(); // 근무 유형 목록
    List<String> getStatuses(); // 재직 상태 목록
}
