package com.beauty1nside.accnut.dto;

import lombok.Data;

@Data
public class AssetSearchDTO extends AssetDTO{
	int start;
	int end;
	int pageUnit;
	
}
