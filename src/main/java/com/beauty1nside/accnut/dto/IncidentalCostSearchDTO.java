package com.beauty1nside.accnut.dto;

import lombok.Data;

@Data
public class IncidentalCostSearchDTO extends IncidentalCostDTO{
	int start;
	int end;
	int pageUnit;
}
