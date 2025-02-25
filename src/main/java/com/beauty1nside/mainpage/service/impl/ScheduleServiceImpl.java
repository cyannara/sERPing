package com.beauty1nside.mainpage.service.impl;

import com.beauty1nside.mainpage.dto.ScheduleDTO;
import com.beauty1nside.mainpage.mapper.ScheduleMapper;
import com.beauty1nside.mainpage.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
@RequiredArgsConstructor
public class ScheduleServiceImpl implements ScheduleService {
  private final ScheduleMapper scheduleMapper;
  
  @Override
  public int insert(ScheduleDTO dto) {
    return scheduleMapper.insert(dto);
  }
  
  @Override
  public int deleteSchedule(Long scheduleId) {
    return scheduleMapper.deleteSchedule(scheduleId);
  }
  
  @Override
  public List<ScheduleDTO> scheduleList(Long companyNum) {
    return scheduleMapper.scheduleList(companyNum);
  }
}
