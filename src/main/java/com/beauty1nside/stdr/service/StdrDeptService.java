package com.beauty1nside.stdr.service;

import com.beauty1nside.stdr.dto.DocumentDTO;

import java.util.List;

public interface StdrDeptService {
  List<DocumentDTO> hqDeptList(DocumentDTO dto);
}
