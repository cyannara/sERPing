package com.beauty1nside.hr.service;

import java.util.List;

import com.beauty1nside.hr.dto.EmpHistoryDTO;
import com.beauty1nside.hr.dto.EmpHistorySearchDTO;


public interface EmpHistoryService {
	
    void insertHistory(EmpHistoryDTO historyDTO);
    
    List<EmpHistoryDTO> listHistory(EmpHistorySearchDTO searchDTO);
    
    int countHistory(EmpHistorySearchDTO searchDTO);
    
    void approveHistory(Long historyNum, Long processedBy);
    
    void rejectHistory(Long historyNum, Long processedBy, String rejectReason);
 
}