package com.beauty1nside.bhf.dto.goodsorderlist;

import lombok.Data;

@Data
public class BhfOrdListSearchDTO extends BhfOrdListDTO {

	int start;
	int end;
	int pageUnit;
	
}
