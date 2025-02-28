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
public class WarehouseDTO {
	//입고서 헤드
	private int warehousingHeaderNum;
	private Date warehousingDate;
	private int employeeNum;
	private int vendorId;
	private Long warehousingChit; 
	private int warehousingTotalAmount;
	private int companyNum;
	
	//데이터 리스트 뿌릴때 기타 
	private String vendorName;
	private String goodsName;
	private String goodsCode;
	private String optionCode;
	private String optionName;
	private String warehouseName;
	private String employeeName;
	private String goodsStandard;
	
	private String startDate ;
	private String endDate;
	
	//입고서 바디 
	private int warehousingBodyNum;
	private String goodsLotNum;
	private Date goodsConsumptionDate;
	private int warehousingStandardQuantity;
	private int warehousingTotalQuantity;
	private int warehousingRemainingQuantity;
	private int warehousingUnitTotalAmount;
	private int warehousingUnitPrice;
	private int warehousingSupplyPrice;
	private int warehousingVat;
	private int warehouseId;
	private int purchaseBodyNum;
	private int optionNum;
	private Date manufactureDate;
	
	
}
