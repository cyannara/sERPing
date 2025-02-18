package com.beauty1nside.purchs.dto;

import java.util.List;

public class ProdInsertVO {

	//프로시저 보낼 값들 순서대로 정렬해서 지정 
	private String goodsName;
	private int goodsCost;
	private int goodsPrice;
	private int goodsSupplyPrice;
	private String goodsStandard;
	private String goodsDescription;
	private String goodsImage;
	private int classificationId;
	private int brandId;
	private int employeeNum;
	private int vendorId;
	private int companyNum;
	private List<ProdInsertDtlVO> files;
	   
	    

}
