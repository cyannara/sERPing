package com.beauty1nside.purchs.dto;

import java.sql.Date;
import java.util.List;

import lombok.Data;

@Data
public class PurchInsertVO {
	//프로시저 보낼 값들 순서대로 정렬해서 지정 
	private int employeeNum;
	private int companyNum;
	private Date purchaseDate;
	private Date purchaseDueDate;
	private int purchaseVatFlag;
	private int vendorId;
	private List<PurchInsertDtlVO> files;
}
