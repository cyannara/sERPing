package com.beauty1nside.purchs.dto;

import lombok.Data;

@Data
public class PurchInsertDtlVO {
	//옵션에 해당 되는 부분(object) 로 보낼 값 지정
	private int companyNum;
	private String goodsStandard;
	private int optionNum;
	// orderPlanBodyNum은 있을 수도 없을 수도 있으므로 Integer로 처리 (null 허용)
	private Integer orderPlanBodyNum;
	private int purchaseQuantity;
	private int purchaseSupplyPrice;
	private int purchaseUnitPrice;
	private int purchaseVat;
	
	public PurchInsertDtlVO(int companyNum, String goodsStandard, int optionNum, Integer orderPlanBodyNum,
			int puchaseQuantity, int purchaseSupplyPrice, int purchaseUnitPrice, int purchaseVat) {
		super();
		this.companyNum = companyNum;
		this.goodsStandard = goodsStandard;
		this.optionNum = optionNum;
		this.orderPlanBodyNum = orderPlanBodyNum;
		this.purchaseQuantity = purchaseQuantity;
		this.purchaseSupplyPrice = purchaseSupplyPrice;
		this.purchaseUnitPrice = purchaseUnitPrice;
		this.purchaseVat = purchaseVat;
	}

	public PurchInsertDtlVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
