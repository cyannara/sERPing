package com.beauty1nside.bhf.dto.closing;

import java.sql.Date;
import java.util.List;

import lombok.Data;

@Data
public class BhfCloseVO {

	private String branchOfficeId;
	private Date closingDate;
	private int businessReserves;
	private int cashAmount;
	private int cashPresent;
	private int cardAmount;
	private int saleAmount;
	private int transferAmount;
	private int companyNum;
	private List<BhfCloseDtlVO> files;
	
}
