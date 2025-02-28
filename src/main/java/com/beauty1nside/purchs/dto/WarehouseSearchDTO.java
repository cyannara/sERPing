package com.beauty1nside.purchs.dto;

import lombok.Data;

@Data
public class WarehouseSearchDTO extends WarehouseDTO{
	int start;
	int end;
	int pageUnit;
}
