package com.beauty1nside.bsn.dto.order;

import java.util.Date;

import com.beauty1nside.bsn.dto.OrderSearchDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BhfOrderDTO extends OrderSearchDTO {
	private String orderCode;
	private String  branchOfficeId;
	private Date orderDate;
	private Date dueDate;
	private String remark;
    private int companyNum;

    private String orderCancelReason;
}
