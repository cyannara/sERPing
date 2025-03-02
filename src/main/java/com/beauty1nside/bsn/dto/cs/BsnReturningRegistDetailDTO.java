package com.beauty1nside.bsn.dto.cs;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BsnReturningRegistDetailDTO {
	
	private String returningDetailCode;
	private String goodsName;
	private String goodsCode;
	private String optionName;
	private String optionCode;
	private String optionBarcode;
	private String exchangeReturningChoice;
	private String returningReason;
	private String goodsLotNum;
	private int quantity;
	private int warehousingQnt;
	private int disuseQnt;

}
