package com.beauty1nside.bsn.dto.order;

import java.math.BigDecimal;

import com.beauty1nside.bsn.dto.OrderSearchDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BsnOrderDetailDTO  extends OrderSearchDTO{
	
	private int orderDetailId;
	private String orderId;
	private String goodsCode;
	private String optionCode;
	private int quantity;
	private String goodsStandard;
	private Double unitPrice;
	private Double summationAmt;
	private String goodsName;
	private String optionName;
	
	

}
