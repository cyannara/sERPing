package com.beauty1nside.purchs.dto;

import java.util.Date;

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
	private int puchaseNum;
	private Date puchaseDate;
	private Date puchaseDueDate;
	private int puchaseVatFlag;
	private int employeeNum;
	private int orderPlanTotalAmount;
	private int companyNum;
	
	
	private String goodsCode;
	private String goodsName;
	private String optionCode;
	private String optionName;
	private String classificationName;
	private String goodsStandard;
	
	//발주서 바디
	private int purchaseBodyNum;
	private int puchaseQuantity;
	private int puchaseUnitPrice;
	private int puchaseSupplyPrice;
	private int puchaseVat;
	private int orderPlanBodyNum;
	private int optionNum;
	private int vendorId;
	private String vendorName;
	
}
