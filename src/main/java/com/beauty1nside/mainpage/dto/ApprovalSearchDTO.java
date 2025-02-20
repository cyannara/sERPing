package com.beauty1nside.mainpage.dto;

import lombok.Data;

@Data
public class ApprovalSearchDTO extends ApprovalDTO {
  private int start;
  private int end;
  private int pageUnit;
  private String inApprovalRequestDateStart;
  private String inApprovalRequestDateEnd;
}
