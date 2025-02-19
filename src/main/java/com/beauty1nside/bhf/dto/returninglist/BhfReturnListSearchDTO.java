package com.beauty1nside.bhf.dto.returninglist;

import lombok.Data;

@Data
public class BhfReturnListSearchDTO extends BhfReturnListDTO {

	int start;
	int end;
	int pageUnit;
}
