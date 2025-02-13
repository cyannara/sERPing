package com.beauty1nside.bsn.dto;

import lombok.Data;

@Data
public class OrderSearchDTO {
	
	int start;
	int end;
	int pageUnit;
	
	String type;
	String keyword;
	
	public String[] getTypeArr() {
		return type == null ?  new String[] {} : type.split("");
	}
}
