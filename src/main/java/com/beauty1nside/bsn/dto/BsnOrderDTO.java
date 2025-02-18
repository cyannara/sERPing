package com.beauty1nside.bsn.dto;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BsnOrderDTO {
	private String orderId;			//bsnOrder의 PK
	private String orderCode;		//bhfOrder의 PK
	private String branchOfficeId;
	private String orderName;
	private Long total_amount;
	private Long purchaseVat;
	private Date orderDate;
	private Date registerDate;
	private Date cancleDate;
	private Date dueDate;
	private Date sendingDate;
	private String orderStatus;
	private int employeeNum;
	private String remark;
	private int companyNum;
	
	private List<BsnOrderDetailDTO> orderDetails;

	
}
