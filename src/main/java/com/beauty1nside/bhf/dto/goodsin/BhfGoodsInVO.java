package com.beauty1nside.bhf.dto.goodsin;

import lombok.Data;

@Data
public class BhfGoodsInVO {

	private String branchOfficeId;
	private String goodsCode;
	private String goodsName;
	private String optionCode;
	private String optionName;
	private String goodsStandard;
	private int stockQuantity;
	private int companyNum;
	
	public BhfGoodsInVO() {}

	public BhfGoodsInVO(String branchOfficeId, String goodsCode, String goodsName, String optionCode, String optionName,
			String goodsStandard, int stockQuantity, int companyNum) {
		super();
		this.branchOfficeId = branchOfficeId;
		this.goodsCode = goodsCode;
		this.goodsName = goodsName;
		this.optionCode = optionCode;
		this.optionName = optionName;
		this.goodsStandard = goodsStandard;
		this.stockQuantity = stockQuantity;
		this.companyNum = companyNum;
	}
	
	
	
}