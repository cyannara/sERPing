package com.beauty1nside.bsn.dto;

import java.math.BigDecimal;
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
	private String orderId;
	private String orderCode;
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
	
	private List<BsnOrderDetailDTO> details;

	public BsnOrderDTO(String orderId, String orderCode, String branchOfficeId, String orderName,
			Long total_amount, Long purchaseVat, Date orderDate, Date registerDate, Date cancleDate,
			Date dueDate, Date sendingDate, String orderStatus, int employeeNum, String remark, int companyNum) {
		super();
		this.orderId = orderId;
		this.orderCode = orderCode;
		this.branchOfficeId = branchOfficeId;
		this.orderName = orderName;
		this.total_amount = total_amount;
		this.purchaseVat = purchaseVat;
		this.orderDate = orderDate;
		this.registerDate = registerDate;
		this.cancleDate = cancleDate;
		this.dueDate = dueDate;
		this.sendingDate = sendingDate;
		this.orderStatus = orderStatus;
		this.employeeNum = employeeNum;
		this.remark = remark;
		this.companyNum = companyNum;
	}
	
	
	
	
	
	
}
