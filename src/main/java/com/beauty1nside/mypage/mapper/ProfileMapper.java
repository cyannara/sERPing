package com.beauty1nside.mypage.mapper;

import com.beauty1nside.hr.dto.EmpDTO;

public interface ProfileMapper {
	EmpDTO info(EmpDTO dto);
	int update(EmpDTO dto);
}
