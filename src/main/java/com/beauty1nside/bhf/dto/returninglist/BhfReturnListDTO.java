package com.beauty1nside.bhf.dto.returninglist;

import java.sql.Date;

import lombok.Data;

@Data
public class BhfReturnListDTO {

	private String returningCode;
	private Date requestDate;
	private String progressStatus;
	private String returnRemark;
	private int companyNum;
	private String branchOfficeId;
	
	private String goodsName;
	private String optionName;
	private int quantity;
	private String exchangeReturningChoice;
	private String returningReason;
	
}
