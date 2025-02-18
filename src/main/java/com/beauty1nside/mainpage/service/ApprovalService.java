package com.beauty1nside.mainpage.service;

import com.beauty1nside.mainpage.dto.ApprovalDTO;
import com.beauty1nside.mainpage.dto.ApprovalSearchDTO;

import java.util.List;

public interface ApprovalService {
  ApprovalDTO info(Long inApprovalId, Long companyNum);
  List<ApprovalDTO> waitingList(ApprovalSearchDTO dto, Long companyNum);
  int count(ApprovalSearchDTO dto, Long companyNum);
  int update(Long inApprovalId, String processStr, Long companyNum);
}
