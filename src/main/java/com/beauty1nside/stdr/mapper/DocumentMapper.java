package com.beauty1nside.stdr.mapper;

import com.beauty1nside.stdr.dto.DocumentDTO;
import com.beauty1nside.stdr.dto.DocumentSearchDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DocumentMapper {
	List<DocumentDTO> documentList(@Param("dto") DocumentSearchDTO dto);
	int count(@Param("dto") DocumentSearchDTO dto);
}
