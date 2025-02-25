package com.beauty1nside.mainpage.mapper;


import com.beauty1nside.mainpage.dto.ScheduleDTO;

import java.util.List;

public interface ScheduleMapper {
  int insert(ScheduleDTO dto);
  List<ScheduleDTO> scheduleList(Long companyNum);
  int deleteSchedule(Long scheduleId);
}
