package com.beauty1nside.bhf.dto.goodsin;

import java.sql.Date;
import java.util.List;

import lombok.Data;

@Data
public class BhfGoodsInVO {

	private String branchOfficeId;
	private Date dueDate;
	private String companyNum;
	private List<BhfGoodsInDtlVO> files;
	
}