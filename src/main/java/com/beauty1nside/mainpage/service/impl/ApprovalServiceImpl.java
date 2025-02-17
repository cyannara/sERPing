package com.beauty1nside.mainpage.service.impl;

import com.beauty1nside.mainpage.dto.ApprovalDTO;
import com.beauty1nside.mainpage.dto.ApprovalSearchDTO;
import com.beauty1nside.mainpage.mapper.ApprovalMapper;
import com.beauty1nside.mainpage.service.ApprovalService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
@RequiredArgsConstructor
public class ApprovalServiceImpl implements ApprovalService{
	
	private final ApprovalMapper approvalMapper;
	
	@Override
	public ApprovalDTO info(Long inApprovalId) {
		return approvalMapper.info(inApprovalId);
	}
	
	@Override
	public List<ApprovalDTO> list(ApprovalSearchDTO dto) {
		return approvalMapper.list(dto);
	}
	
	@Override
	public int count(ApprovalSearchDTO dto) {
		return approvalMapper.count(dto);
	}
}
