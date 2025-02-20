package com.beauty1nside.bhf.dto.goodsorderlist;

import lombok.Data;

@Data
public class BhfOrdCancelDTO {

	private String orderCode;
	private String progressStatus;
	private String orderCancelReason;
	
}
