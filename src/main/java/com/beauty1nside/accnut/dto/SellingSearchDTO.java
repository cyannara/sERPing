package com.beauty1nside.accnut.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class SellingSearchDTO extends SellingDTO{
	int start;
	int end;
	int pageUnit;
	Date startDate;
	Date endDate;
	
	
}
