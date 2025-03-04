package com.beauty1nside.bsn.dto.order;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BsnOrderHistoryDTO {
	private int historyNum;
	private String orderId;
	private String historyType;
	private Date registerDate ;
	private String historyContents;
}
