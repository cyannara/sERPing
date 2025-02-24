package com.beauty1nside.bhf.dto.goodsin;

import lombok.Data;

@Data
public class BhfGoodsInDtlVO {

	private String branchOfficeId;
	private String goodsCode;
	private String goodsName;
	private String optionCode;
	private String optionName;
	private String goodsStandard;
	private int quantity;
	private int stockQuantity;
	private int inQuantity;
	private int companyNum;
	private int reorder;
	private int returnNum;
	
}
