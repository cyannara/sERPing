package com.beauty1nside.purchs.dto;

import lombok.Data;

@Data
public class ProdInsertDtlVO {
//옵션에 해당 되는 부분(object) 로 보낼 값 지정
	private String optionName;
	private int warehouseId;
	
	public ProdInsertDtlVO(String optionName, int warehouseId) {
		super();
		this.optionName = optionName;
		this.warehouseId = warehouseId;
	}

	public ProdInsertDtlVO() {}
	
	
	
}
