package com.beauty1nside.purchs.dto;

import groovy.transform.builder.Builder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class ProductDTO {
	//상품
	private String goodsName;
	private int goodsCost;
	private String goodsCode;
	private int goodsPrice;
	private int goodsSupplyPrice;
	private String goodsStandard;
	private String goodsDescription;
	private String goodsImage;
	private Long classificationId;
	private Long blandId;
	private Long employeeNum;
	private Long vendorId;
	
	
	//옵션
	private String optionCode;
	private String optionName;
	private int optionSafetyInvoice;
	private Long warehouseId;
	
}
