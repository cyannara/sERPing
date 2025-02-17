package com.beauty1nside.bsn.dto;


import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class OrderSearchDTO {
	
	int start;
	int end;
	int pageUnit;
	
	String type;
	String keyword;
	
	//발주 요청 검색용
	String deteOption;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	Date startDate;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	Date endDate;
	String branch;
	
	
	
	
//	public String[] getTypeArr() {
//		return type == null ?  new String[] {} : type.split("");
//	}
}
