package com.beauty1nside.bsn.dto.order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BsnOrderCancelDTO {
	private String orderId;
	private String orderCancelReason;

}
