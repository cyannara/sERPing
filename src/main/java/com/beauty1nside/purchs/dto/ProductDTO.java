package com.beauty1nside.purchs.dto;

import org.springframework.beans.factory.annotation.Value;

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
	
	private String classificationName;
	private String classificationCode;
	private int classificationId;
	
	private Long brandId;
	private String brandCode;
	private String brandName;
	
	private Long employeeNum;
	private String emloyeeName;
	
	private Long vendorId;
	private String vendorName;
	
	
	//옵션
	private String optionCode;
	private String optionName;
	private int optionSafetyInvoice;
	
	private Long warehouseId;
	private String warehouseName;
	
	//파일 이미지 업로드
	@Value("${img.upload}")
	private String imgUpload;
	

	
	
}
