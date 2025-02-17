package com.beauty1nside.purchs.dto;

import lombok.Data;

@Data
public class ProductSearchDTO extends ProductDTO{
	int start;
	int end;
	int pageUnit;
}
