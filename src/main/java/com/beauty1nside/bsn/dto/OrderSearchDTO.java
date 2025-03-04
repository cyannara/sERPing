package com.beauty1nside.bsn.dto;


import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class OrderSearchDTO {
	
	int start;
	int end;
	int pageUnit;
	
	int companyNum;
	
	//발주 요청 검색용
	String branch;
	String deteOption;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	Date startDate;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	Date endDate;
	
	
	
	
//	public String[] getTypeArr() {
//		return type == null ?  new String[] {} : type.split("");
//	}
}
