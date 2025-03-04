package com.beauty1nside.bsn.dto;

import java.util.Date;

import com.beauty1nside.purchs.dto.ProductSearchDTO;

import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BsnGoodsLOTDTO {
	private String goodsLotNum;
	private Date goodsConsumptionDate;
	private int warehousingStandardQuantity;
	private int warehousingTotalQuantity;
	private int warehousingRemainingQuantity; 


    
}
