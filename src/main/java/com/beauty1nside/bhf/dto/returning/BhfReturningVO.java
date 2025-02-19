package com.beauty1nside.bhf.dto.returning;

import java.util.List;

import lombok.Data;

@Data
public class BhfReturningVO {

	private String branchOfficeId;
	private String remark;
	private int companyNum;
	private List<BhfReturningDtlVO> files; //반품 상세 테이블에 해당하는 값들을 배열로 담음
	
}
