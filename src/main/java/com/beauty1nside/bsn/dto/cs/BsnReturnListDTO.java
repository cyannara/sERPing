package com.beauty1nside.bsn.dto.cs;

import java.sql.Date;

import com.beauty1nside.bhf.dto.returninglist.BhfReturnListDTO;

import lombok.Data;

@Data
public class BsnReturnListDTO  extends BhfReturnListDTO {
	
	
//	private String returningCode;
//	private Date requestDate;
//	private String progressStatus;
//	private String returnRemark;
//	private int companyNum;
//	private String branchOfficeId;
//	
//	private String goodsName;
//	private String optionName;
//	private int quantity;
//	private String exchangeReturningChoice;
//	private String returningReason;
	
	private String returningDetailCode;
	private String goodsCode;
	private String optionCode;
	private String optionBarcode;
	private String goodsLotNum;

}
