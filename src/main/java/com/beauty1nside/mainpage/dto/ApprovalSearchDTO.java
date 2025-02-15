package com.beauty1nside.mainpage.dto;

import lombok.Data;

@Data
public class ApprovalSearchDTO extends ApprovalDTO {
  int start;
  int end;
  int pageUnit;
}
