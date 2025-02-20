package com.beauty1nside.bhf.dto.goodsin;

import lombok.Data;

@Data
public class BhfGoodsOrdSearchDTO extends BhfGoodsOrdDTO {

	int start;
	int end;
	int pageUnit;
	
}