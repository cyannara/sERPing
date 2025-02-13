package com.beauty1nside.accnut.dto;

import lombok.Data;

@Data
public class DebtSearchDTO extends DebtDTO{
	int start;
	int end;
	int pageUnit;
	
}
