package com.beauty1nside.bhf.dto.returning;

import lombok.Data;

@Data
public class BhfReturningDtlVO {

	private String goodsCode;
	private String goodsName;
	private String optionCode;
	private String optionName;
	private int quantity;
	private String exchangeReturningChoice;
	private String returningReason;
	
	public BhfReturningDtlVO(String goodsCode, String goodsName, String optionCode, String optionName, int quantity,
							String exchangeReturningChoice, String returningReason) {
		super();
		this.goodsCode = goodsCode;
		this.goodsName = goodsName;
		this.optionCode = optionCode;
		this.optionName = optionName;
		this.quantity = quantity;
		this.exchangeReturningChoice = exchangeReturningChoice;
		this.returningReason = returningReason;
	}
	
	public BhfReturningDtlVO() {}
	
}
