package com.beauty1nside.bhf.dto.goodsin;

import java.sql.Date;
import java.util.List;

import lombok.Data;

@Data
public class BhfGoodsInVO {

	private String branchOfficeId;
	private Date dueDate;
	private int companyNum;
	private String deliveryId;
	private String orderCode;
	private List<BhfGoodsInDtlVO> files;
	
}