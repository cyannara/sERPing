package com.beauty1nside.erp.dto;

import lombok.Data;

@Data
public class CompanyListSearchDTO {
	int start;
	int end;
	
	//페이징 클래스에도 담고 여기에도 담는다 (같은이름으로 하s면 여긴 값을 유지하기위해서)
	// 페이징에서는 몇페이징 뜨게하기위해서 
	int pageUnit;
	
	String keyword;
	
	String type;
	public String[] getTypeArr() {
		return type == null ? new String[] {} : type.split("");
	}  
}