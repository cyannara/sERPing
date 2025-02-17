package com.beauty1nside.accnut.dto;

import lombok.Data;

@Data
public class EtcBookSearchDTO extends EtcBookDTO{
	int start;
	int end;
	int pageUnit;
}
