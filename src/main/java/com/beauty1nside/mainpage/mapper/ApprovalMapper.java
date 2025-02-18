package com.beauty1nside.mainpage.mapper;

import com.beauty1nside.mainpage.dto.ApprovalDTO;
import com.beauty1nside.mainpage.dto.ApprovalSearchDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ApprovalMapper {
	ApprovalDTO info(@Param("inApprovalId") Long inApprovalId, @Param("companyNum") Long companyNum);
	List<ApprovalDTO> waitingList(@Param("dto") ApprovalSearchDTO dto, @Param("companyNum") Long companyNum);
	int count(@Param("dto") ApprovalSearchDTO dto, @Param("companyNum") Long companyNum);
	int update(@Param("inApprovalId") Long inApprovalId, @Param("processStr") String processStr, @Param("companyNum") Long companyNum);
}
