package com.beauty1nside.purchs.dto;

import java.util.Date;

import org.apache.ibatis.annotations.Param;
import org.springframework.format.annotation.DateTimeFormat;

import groovy.transform.builder.Builder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseDTO {
	//발주서 헤드
	private Long purchaseNum;
	private Date purchaseDate;
	private Date purchaseDueDate;
	private int purchaseVatFlag;
	private int employeeNum;
	private String employeeName;
	private int companyNum;
	private int purchaseTotalAmount;
	private String purchaseStatus;
	private String businessNum;
	private String representationName;
	
	//기타
	private String goodsCode;
	private String goodsName;
	private String optionCode;
	private String optionName;
	private String classificationName;
	private String goodsStandard;
	private String employeePhone;
	private String employeeEmail;
	
	
	private String startDate ;
	private String endDate;
	
	private int nonWarehousingNum;
	
	
	
	//발주서 바디
	private int purchaseBodyNum;
	private int purchaseQuantity;
	private int purchaseUnitPrice;
	private int purchaseSupplyPrice;
	private int purchaseVat;
	private int orderPlanBodyNum;
	private int vendorId;
	private String vendorName;
	private String vendorEmail; 
	private String vendorPhone;
	private int optionNum;

	
	
	
}
