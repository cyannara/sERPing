package com.beauty1nside.mainpage.service;

import com.beauty1nside.mainpage.dto.ApprovalDTO;
import com.beauty1nside.mainpage.dto.ApprovalSearchDTO;

import java.util.List;

public interface ApprovalService {
  ApprovalDTO info(Long inApprovalId);
  List<ApprovalDTO> list(ApprovalSearchDTO dto);
  int count(ApprovalSearchDTO dto);
}
