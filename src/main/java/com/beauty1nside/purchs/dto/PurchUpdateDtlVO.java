package com.beauty1nside.purchs.dto;

import lombok.Data;

@Data
public class PurchUpdateDtlVO {
	private int purchaseBodyNum;
    private int purchaseQuantity;
    private int purchaseUnitPrice;
    private int purchaseSupplyPrice;
    private int purchaseVat;
    private int optionNum;
    private String goodsStandard;
    private int companyNum;
    
    
	public PurchUpdateDtlVO(int purchaseBodyNum, int purchaseQuantity, int purchaseUnitPrice, int purchaseSupplyPrice,
			int purchaseVat, int optionNum, String goodsStandard, int companyNum) {
		super();
		this.purchaseBodyNum = purchaseBodyNum;
		this.purchaseQuantity = purchaseQuantity;
		this.purchaseUnitPrice = purchaseUnitPrice;
		this.purchaseSupplyPrice = purchaseSupplyPrice;
		this.purchaseVat = purchaseVat;
		this.optionNum = optionNum;
		this.goodsStandard = goodsStandard;
		this.companyNum = companyNum;
	}
	public PurchUpdateDtlVO() {}
    
    
}
