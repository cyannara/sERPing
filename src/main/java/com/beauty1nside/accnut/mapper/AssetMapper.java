package com.beauty1nside.accnut.mapper;

import java.util.List;

import com.beauty1nside.accnut.dto.AssetDTO;

public interface AssetMapper {

	AssetDTO info(String assetsCode);
	List<AssetDTO> list();
	int count();
}
