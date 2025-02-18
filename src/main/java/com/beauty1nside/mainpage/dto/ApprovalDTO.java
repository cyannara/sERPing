package com.beauty1nside.mainpage.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ApprovalDTO {
  private Long inApprovalId;
  private Long documentId;
  private Long employeeNum;
  private Date inApprovalRequestDate;
  private String inApprovalStatus;
  private String inApprovalRequestContent;
  private String inApprovalRejectedContent;
  private String inApprovalFilePath;
  private Long companyNum;
}
