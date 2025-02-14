package com.beauty1nside.bhf.dto.goodsorder;

import lombok.Data;

@Data
public class BhfGoodsOpDTO {

	private String goodsCode;
	private String goodsName;
	private String goodsStandard;
	
	private String optionCode;
	private String optionName;
	
	private int companyNum;
	
}
