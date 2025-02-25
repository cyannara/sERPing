package com.beauty1nside.mainpage.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ScheduleDTO {
  private Long scheduleId;
  private String scheduleType; // 'DEPT', 'PERSONAL'
  private String scheduleContent;
  private Date scheduleStart;
  private Date scheduleEnd;
  private Long employeeNum;
  private Long companyNum;
  private Long deptNo;
  private String isAllday; // N, Y
  private String isPrivate; // N, Y
  private String location;
}
