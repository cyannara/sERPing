package com.beauty1nside.bsn.dto.delivery;

import java.util.List;

import com.beauty1nside.bsn.dto.OrderSearchDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class BsnDeliveryDetailDTO extends BsnDeliverySearchDTO {
	private int deliveryDetailId;
	private String deliveryId;
	private int orderDetailId;
	private String optionCode;
	private int deliveryDemandQnt;
	private int deliveryTotalQnt;
	private int sufficiencyStatus;

	private String goodsName;
	private String optionName;
	private String goodsStandard;
	
	private List<BsnDeliveryLotDTO> lotDetails;
}
