package com.beauty1nside.purchs.dto;

import java.util.List;

import lombok.Data;

@Data
public class WarehouseInsertVO {
	//프로시저 보낼 값들 순서대로 정렬 해서 지정 
	private int employeeNum;
	private int companyNum;
	private int vendorId;
	private List<WarehouseInsertDtlVO> files;
}
