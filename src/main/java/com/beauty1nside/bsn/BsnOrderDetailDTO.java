package com.beauty1nside.bsn;

import java.math.BigDecimal;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BsnOrderDetailDTO {
	
	private int orderDetailId;
	private String orederId;
	private int goodsNum;
	private int optionNum;
	private int quantity;
	private String goodsStandard;
	private BigDecimal unitPrice;
	private BigDecimal summationAmt;
	
	

}
