package com.beauty1nside.bhf.dto.goodsorder;

import lombok.Data;

@Data
public class BhfOrdDtlVO {

	private String goodsCode;
	private String goodsName;
	private String optionCode;
	private String optionName;
	private String goodsStandard;
	private int quantity;
	
	public BhfOrdDtlVO(String goodsCode, String goodsName, String optionCode, String optionName, String goodsStandard, int quantity) {
		super();
		this.goodsCode = goodsCode;
		this.goodsName = goodsName;
		this.optionCode = optionCode;
		this.optionName = optionName;
		this.goodsStandard = goodsStandard;
		this.quantity = quantity;
	}

	public BhfOrdDtlVO() {}
	
}
