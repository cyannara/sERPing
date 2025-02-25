package com.beauty1nside.bsn.dto.delivery;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BsnDeliveryLotDTO {
	private int DeliveryLotDetailNum;	//예약번호
	private int DeliveryDetailId;
	private String GoodsLotNum;
	private int DeliveryPossibleQnt;
	private int DeliveryQnt;
	
	
	private Date goodsConsumptionDate;
}
