package com.beauty1nside.bhf.dto.goodsorder;

import lombok.Data;

@Data
public class BhfOrdSearchDTO extends BhfGoodsOpDTO {
	
	int start;
	int end;
	int pageUnit;
	
}
