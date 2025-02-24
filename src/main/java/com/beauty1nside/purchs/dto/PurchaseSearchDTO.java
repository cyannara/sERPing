package com.beauty1nside.purchs.dto;

import lombok.Data;

@Data
public class PurchaseSearchDTO extends PurchaseDTO{
	int start;
	int end;
	int pageUnit;
}
