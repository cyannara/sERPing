package com.beauty1nside.stdr.service;

import com.beauty1nside.stdr.dto.DocumentDTO;
import com.beauty1nside.stdr.dto.DocumentSearchDTO;

import java.util.List;

public interface DocumentService {
  List<DocumentDTO> documentList(DocumentSearchDTO dto);
  int count(DocumentSearchDTO dto);
  int insert(DocumentDTO dto);
  DocumentDTO info(DocumentDTO dto);
}
