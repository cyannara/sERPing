package com.beauty1nside.bsn.dto.cs;

import java.util.List;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class BsnReturningRegistDTO {
	
	private int companyNum;
	private int employeeNum;
	private String branchOfficeId;
	private String returningCode;
	// cs기록
	private List<BsnReturningRegistDetailDTO> returningDetailData;
	// 교환 등록용
	private List<BsnReturningRegistDetailDTO> exchangeList;
	// 입고 처리용
	private List<BsnReturningRegistDetailDTO> warehousingList;



}
