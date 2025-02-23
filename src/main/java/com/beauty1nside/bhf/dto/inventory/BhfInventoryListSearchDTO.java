package com.beauty1nside.bhf.dto.inventory;

import lombok.Data;

@Data
public class BhfInventoryListSearchDTO extends BhfInventoryListDTO {

	int start;
	int end;
	int pageUnit;
	
}
