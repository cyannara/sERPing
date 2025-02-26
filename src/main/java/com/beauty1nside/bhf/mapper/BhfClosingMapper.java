package com.beauty1nside.bhf.mapper;

import com.beauty1nside.bhf.dto.closing.BhfCloseVO;

public interface BhfClosingMapper {

	//마감정산 프로시져
	public void bhf_close(BhfCloseVO vo);
	
}
