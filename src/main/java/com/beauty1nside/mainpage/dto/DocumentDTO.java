package com.beauty1nside.mainpage.dto;

import lombok.Data;

@Data
public class DocumentDTO {
  private Long documentId;
  private String documentType;
  private String documentName;
  private String documentTemplate;
  private String deptName;
  private String approvalType;
  private String companyNum;
}
