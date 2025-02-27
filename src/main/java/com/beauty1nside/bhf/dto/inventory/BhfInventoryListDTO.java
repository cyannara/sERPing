package com.beauty1nside.bhf.dto.inventory;

import lombok.Data;

@Data
public class BhfInventoryListDTO {

	private String goodsCode;
	private String goodsName;
	private String optionCode;
	private String optionName;
	private String goodsStandard;
	private int stockQuantity;
	private int quantity;
	private int mediationQuantity;
	
	private String warehouseCode;
	private String branchOfficeId;
	private int companyNum;
}
