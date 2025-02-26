package com.beauty1nside.bhf.dto.goodsin;

import java.sql.Date;

import lombok.Data;

@Data
public class BhfGoodsOrdDTO {
	
	private String deliveryId;
	private String orderCode;
	private Date deliveryDate;
	private Date orderDate;
	private Date dueDate;
	private String remark;
	
	private String goodsCode;
	private String goodsName;
	private String optionCode;
	private String optionName;
	private String goodsStandard;
	private int quantity;
	private String goodsLotNum;
	private String optionBarcode;
	private Date goodsConsumptionDate;
	
	private String branchOfficeId;
	private int companyNum;
	
}