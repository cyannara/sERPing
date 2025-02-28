package com.beauty1nside.bhf.dto.erpboard;

import lombok.Data;

@Data
public class ErpBoardListSearchDTO extends ErpBoardListDTO {

	int start;
	int end;
	int pageUnit;
	
}
