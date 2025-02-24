package com.beauty1nside.purchs.dto;

import lombok.Data;

@Data
public class ProdInsertDtlVO {

	private String optionName;
	private int warehouseId;
	
	public ProdInsertDtlVO(String optionName, int warehouseId) {
		super();
		this.optionName = optionName;
		this.warehouseId = warehouseId;
	}

	public ProdInsertDtlVO() {}
	
	
	
}
