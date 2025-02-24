package com.beauty1nside.hr.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.beauty1nside.hr.dto.DeptDTO;

@Mapper
public interface DeptMapper {
	
    // 부서 전체 목록 조회
    List<DeptDTO> list(Long companyNum);
    
    // 회사 정보 조회 (회사명, 영문명, 회사번호)
    DeptDTO getCompanyInfo(Long companyNum);

}
