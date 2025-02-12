package com.beauty1nside.bhf.dto;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class BhfOrdVO {

	private String branchOfficeId;
	private Date dueDate;
	private String remark;
	private int companyNum;
	private List<BhfOrdDtlVO> files;
	
}
