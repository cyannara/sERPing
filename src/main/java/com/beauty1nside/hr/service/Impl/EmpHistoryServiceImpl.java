package com.beauty1nside.hr.service.Impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.beauty1nside.hr.dto.EmpHistoryDTO;
import com.beauty1nside.hr.dto.EmpHistorySearchDTO;
import com.beauty1nside.hr.mapper.EmpHistoryMapper;
import com.beauty1nside.hr.service.EmpHistoryService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service // ★이거 무조건 넣어!!
//@AllArgsConstructor	//모든필드를 생성자 초기화 한다
@RequiredArgsConstructor // 파이널 붙어 있는 필드만 초기화 해준다
//필드 하나뿐이면 그냥 all 하고 여러개이면 Required
public class EmpHistoryServiceImpl implements EmpHistoryService {

	private final EmpHistoryMapper empHistoryMapper;

    @Override
    public void insertHistory(EmpHistoryDTO historyDTO) {
        empHistoryMapper.insertHistory(historyDTO);
    }

    @Override
    public List<EmpHistoryDTO> listHistory(EmpHistorySearchDTO searchDTO) {
        return empHistoryMapper.listHistory(searchDTO);
    }

    @Override
    public int countHistory(EmpHistorySearchDTO searchDTO) {
        return empHistoryMapper.countHistory(searchDTO);
    }

    @Transactional
    @Override
    public void approveHistory(Long historyNum, Long processedBy) {
        empHistoryMapper.approveHistory(historyNum, processedBy);
    }

    @Transactional
    @Override
    public void rejectHistory(Long historyNum, Long processedBy, String rejectReason) {
        empHistoryMapper.rejectHistory(historyNum, processedBy, rejectReason);
    }



}
