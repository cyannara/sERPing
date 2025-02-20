package com.beauty1nside.stdr.dto;

import lombok.Data;

@Data
public class DocumentDTO {
  private Long documentId;
  private String documentType;
  private String documentName;
  private String documentTemplate;
  private String deptName;
  private String approvalType;
  private Long companyNum;
}
