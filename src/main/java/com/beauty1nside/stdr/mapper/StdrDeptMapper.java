package com.beauty1nside.stdr.mapper;

import com.beauty1nside.stdr.dto.DocumentDTO;

import java.util.List;

public interface StdrDeptMapper {
	List<DocumentDTO> hqDeptList(DocumentDTO dto);
}
