package com.beauty1nside.stdr.mapper;

import com.beauty1nside.hr.dto.DeptDTO;
import java.util.List;

public interface StdrDeptMapper {
	List<DeptDTO> hqDeptList(Long CompanyNum);
}
