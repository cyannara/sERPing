package com.beauty1nside.bhf.dto.returning;

import lombok.Data;

@Data
public class BhfGdsOptSearchDTO extends BhfGdsOptDTO {

	int start;
	int end;
	int pageUnit;
	
}
