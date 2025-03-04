package com.beauty1nside.bsn.dto.cs;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BsnReturningRefusalDTO {
	private String  returningCode;
	private String  returnRemark;
}
