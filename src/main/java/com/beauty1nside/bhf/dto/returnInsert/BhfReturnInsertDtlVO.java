package com.beauty1nside.bhf.dto.returnInsert;

import lombok.Data;

@Data
public class BhfReturnInsertDtlVO {

	private String goodsCode;
	private String goodsName;
	private String optionCode;
	private String optionName;
	private int quantity;
	private String exchangeReturningChoice;
	private String returningReason;
	private String optionBarcode;
	private String goodsLotNum;
	
	public BhfReturnInsertDtlVO() {}

	public BhfReturnInsertDtlVO(String goodsCode, String goodsName, String optionCode, String optionName, int quantity,
			String exchangeReturningChoice, String returningReason, String optionBarcode, String goodsLotNum) {
		super();
		this.goodsCode = goodsCode;
		this.goodsName = goodsName;
		this.optionCode = optionCode;
		this.optionName = optionName;
		this.quantity = quantity;
		this.exchangeReturningChoice = exchangeReturningChoice;
		this.returningReason = returningReason;
		this.optionBarcode = optionBarcode;
		this.goodsLotNum = goodsLotNum;
	}
	
	
	
}
