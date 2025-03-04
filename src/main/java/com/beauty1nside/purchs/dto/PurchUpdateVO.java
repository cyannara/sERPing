package com.beauty1nside.purchs.dto;

import java.sql.Date;
import java.util.List;

import lombok.Data;

@Data
public class PurchUpdateVO {
	 private Long purchaseNum;
	 private int employeeNum;
	 private int companyNum;
	 private Date purchaseDueDate;
	 private int purchaseVatFlag;
	 private String purchaseRecordeReason;
	 private List<PurchUpdateDtlVO> files;  
}
