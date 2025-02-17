package com.beauty1nside.mainpage.service;

import com.beauty1nside.mainpage.dto.ApprovalDTO;
import com.beauty1nside.mainpage.dto.ApprovalSearchDTO;

import java.util.List;

public interface ApprovalService {
  ApprovalDTO info(Long inApprovalId, Long companyNum);
  List<ApprovalDTO> list(ApprovalSearchDTO dto, Long companyNum);
  int count(ApprovalSearchDTO dto, Long companyNum);
}
