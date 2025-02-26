package com.beauty1nside.chat.dto;

import lombok.Data;

import java.util.Date;

@Data
public class MessageDTO {
  private Long msg_id;
  private Long room_id;
  private Long employee_num;
  private String msg_content;
  private Date send_date;
}
