package com.beauty1nside.bhf.dto.goodsorder;

import java.sql.Date;
import java.util.List;

import lombok.Data;

@Data
public class BhfOrdVO {

	private String branchOfficeId;
	private Date dueDate;
	private String remark;
	private int companyNum;
	private List<BhfOrdDtlVO> files; //발주 상세 테이블에 해당하는 값들을 배열로 담음
	
}
