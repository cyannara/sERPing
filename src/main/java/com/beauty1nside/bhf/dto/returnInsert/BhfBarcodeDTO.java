package com.beauty1nside.bhf.dto.returnInsert;

import java.sql.Date;

import lombok.Data;

@Data
public class BhfBarcodeDTO {

	private String branchOfficeId;
	private String goodsCode;
	private String goodsName;
	private String optionCode;
	private String optionName;
	private String goodsBarcode;
	private String goodsLotNum;
	private Date goodsConsumptionDate;
	
	private int companyNum;
	
}
