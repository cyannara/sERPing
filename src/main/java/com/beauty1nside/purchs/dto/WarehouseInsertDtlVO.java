package com.beauty1nside.purchs.dto;

import java.util.Date;

import lombok.Data;

@Data
public class WarehouseInsertDtlVO {
	//옵션에 해당되는 부분 (object) 로 보낼 값 지정
	private String goodsStandard;
	private int warehouseId;
	private int warehousingStandardQuantity;
	private int warehousingUnitPrice;
	private int warehousingSupplyPrice;
	private int warehousingVat;
	private int optionNum;
	// purchaseBodyNum은 있을 수도 없을 수도 있으므로 Integer로 처리 (null 허용)
	private Integer purchaseBodyNum;
	private Date manufactureDate;
	
	
	public WarehouseInsertDtlVO(String goodsStandard, int warehouseId, int warehousingStandardQuantity,
			int warehousingUnitPrice, int warehousingSupplyPrice, int warehousingVat, int optionNum,
			Integer purchaseBodyNum, Date manufactureDate) {
		super();
		this.goodsStandard = goodsStandard;
		this.warehouseId = warehouseId;
		this.warehousingStandardQuantity = warehousingStandardQuantity;
		this.warehousingUnitPrice = warehousingUnitPrice;
		this.warehousingSupplyPrice = warehousingSupplyPrice;
		this.warehousingVat = warehousingVat;
		this.optionNum = optionNum;
		this.purchaseBodyNum = purchaseBodyNum;
		this.manufactureDate = manufactureDate;
	}
	
}
