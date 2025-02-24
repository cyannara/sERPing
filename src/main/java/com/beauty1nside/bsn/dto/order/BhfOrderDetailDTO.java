package com.beauty1nside.bsn.dto.order;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class BhfOrderDetailDTO {
	private String orderDetailCode;
	private String orderCode;
	private String  goodsCode;
	private String  goodsName;
	private String  optionCode;
	private String  optionName;
	private String goodsStandard;
    private int quantity;
}
