package com.beauty1nside.bsn.dto.delivery;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class BsnDeliverySearchDTO {
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
	List<String> statusList;
}
