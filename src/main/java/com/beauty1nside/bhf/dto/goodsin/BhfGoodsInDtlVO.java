package com.beauty1nside.bhf.dto.goodsin;

import java.sql.Date;

import lombok.Data;

@Data
public class BhfGoodsInDtlVO {

	private String branchOfficeId;
	private int companyNum;
	private String goodsCode;
	private String goodsName;
	private String optionCode;
	private String optionName;
	private String goodsStandard;
	private int quantity;
	private int stockQuantity;
	private int inQuantity;
	private int reorder;
	private int returnNum;
	private String goodsLotNum;
	private String optionBarcode;
	private Date goodsConsumptionDate;
	
}
