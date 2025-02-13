package com.beauty1nside.bsn.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BhfOrderDTO {
	private String orderCode;
	private String  branchOfficeId;
	private Date orderDate;
	private Date dueDate;
	private String remark;
    private int companyNum;
}
