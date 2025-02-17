package com.beauty1nside.accnut.dto;

import lombok.Data;

@Data
public class SalaryBookSearchDTO extends SalaryBookDTO{
	int start;
	int end;
	int pageUnit;
}
