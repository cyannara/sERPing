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
	public ApprovalDTO info(Long inApprovalId, Long companyNum) {
		return approvalMapper.info(inApprovalId, companyNum);
	}
	
	@Override
	public List<ApprovalDTO> waitingList(ApprovalSearchDTO dto, Long companyNum) {
		return approvalMapper.waitingList(dto, companyNum);
	}
	
	@Override
	public int count(ApprovalSearchDTO dto, Long companyNum) {
		return approvalMapper.count(dto, companyNum);
	}
	
	@Override
	public int update(Long inApprovalId, String processStr, Long companyNum) {
		return approvalMapper.update(inApprovalId, processStr, companyNum);
	}
}
