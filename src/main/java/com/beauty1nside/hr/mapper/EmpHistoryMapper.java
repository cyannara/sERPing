package com.beauty1nside.hr.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.beauty1nside.hr.dto.EmpHistoryDTO;
import com.beauty1nside.hr.dto.EmpHistorySearchDTO;

@Mapper
public interface EmpHistoryMapper {
	
    // 인사발령 등록
    void insertHistory(EmpHistoryDTO historyDTO);

    // 인사발령 목록 조회 (페이징)
    List<EmpHistoryDTO> listHistory(EmpHistorySearchDTO searchDTO);

    // 인사발령 개수 조회 (페이징을 위한 전체 개수)
    int countHistory(EmpHistorySearchDTO searchDTO);

    // 인사발령 승인 (승인자 정보 업데이트 & 적용일 반영)
    void approveHistory(Long historyNum, Long processedBy);

    // 인사발령 반려 (반려 사유 포함)
    void rejectHistory(Long historyNum, Long processedBy, String rejectReason);

}
