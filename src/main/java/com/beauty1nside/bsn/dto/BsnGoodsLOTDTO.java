package com.beauty1nside.bsn.dto;

import java.util.Date;

import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BsnGoodsLOTDTO  {//extends ProductSearchDTO
	private String goodsLotNum;
	private Date goodsConsumptionDate;
	private int warehousingStandardQuantity;
	private int warehousingTotalQuantity;
	private int warehousingRemainingQuantity; 
	
	private int warehousingBodyNum;
    private int optionNum; 
    private String optionCode; 



    
}
