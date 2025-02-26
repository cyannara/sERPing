package com.beauty1nside.stdr.mapper;

import com.beauty1nside.stdr.dto.DocumentDTO;
import com.beauty1nside.stdr.dto.StdrDeptDTO;

import java.util.List;

public interface StdrDeptMapper {
	List<StdrDeptDTO> hqDeptList(Long CompanyNum);
	List<StdrDeptDTO> deptList(Long companyNum);
}
