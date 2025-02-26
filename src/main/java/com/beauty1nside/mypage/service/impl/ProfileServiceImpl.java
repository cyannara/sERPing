package com.beauty1nside.mypage.service.impl;

import com.beauty1nside.hr.dto.EmpDTO;
import com.beauty1nside.mypage.mapper.ProfileMapper;
import com.beauty1nside.mypage.service.ProfileService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@RequiredArgsConstructor
public class ProfileServiceImpl implements ProfileService {
	
	private final ProfileMapper profileMapper;
	
	@Override
	public EmpDTO info(EmpDTO dto) {
		return profileMapper.info(dto);
	}
	
	@Override
	public int update(EmpDTO dto) {
		return profileMapper.update(dto);
	}
}
