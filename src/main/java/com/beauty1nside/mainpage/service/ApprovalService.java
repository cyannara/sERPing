package com.beauty1nside.mainpage.service;

import com.beauty1nside.mainpage.dto.ApprovalDTO;
import com.beauty1nside.mainpage.dto.ApprovalSearchDTO;
import com.beauty1nside.stdr.dto.DocumentDTO;

import java.util.List;

public interface ApprovalService {
  ApprovalDTO info(Long inApprovalId, Long companyNum);
  List<ApprovalDTO> waitingList(ApprovalSearchDTO dto, Long companyNum);
  List<ApprovalDTO> myList(ApprovalSearchDTO dto);
  int count(ApprovalSearchDTO dto, Long companyNum);
  int myCount(ApprovalSearchDTO dto);
  int update(ApprovalDTO dto);
  List<DocumentDTO> documentList(Long companyNum);
}
