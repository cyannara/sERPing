package com.beauty1nside.accnut.dto;

import lombok.Data;

@Data
public class DealBookSearchDTO extends DealBookDTO {
	int start;
	int end;
	int pageUnit;
}
