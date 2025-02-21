package com.beauty1nside.bhf.dto.returnInsert;

import lombok.Data;

@Data
public class BhfBarcodeSearchDTO extends BhfBarcodeDTO {

	int start;
	int end;
	int pageUnit;
	
}
