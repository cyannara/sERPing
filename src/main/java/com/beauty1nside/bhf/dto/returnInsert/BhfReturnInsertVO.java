package com.beauty1nside.bhf.dto.returnInsert;

import java.util.List;

import lombok.Data;

@Data
public class BhfReturnInsertVO {

	private String branchOfficeId;
	private String returnRemark;
	private int companyNum;
	private List<BhfReturnInsertDtlVO> files; //반품 상세 테이블에 해당하는 값들을 배열로 담음
	
}
