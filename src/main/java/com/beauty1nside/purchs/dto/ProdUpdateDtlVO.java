package com.beauty1nside.purchs.dto;

import lombok.Data;

@Data
public class ProdUpdateDtlVO {
	private int optionNum;
	private String optionName;
	private int optionSafetyInvoice;
	private int warehouseId;
	private int optionUseFlag;
	
	public ProdUpdateDtlVO(int optionNum, String optionName, int optionSafetyInvoice, int warehouseId,
			int optionUseFlag) {
		super();
		this.optionNum = optionNum;
		this.optionName = optionName;
		this.optionSafetyInvoice = optionSafetyInvoice;
		this.warehouseId = warehouseId;
		this.optionUseFlag = optionUseFlag;
	}

	public ProdUpdateDtlVO() {}
	
	
	
	
}
