package com.beauty1nside.accnut.mapper;

import java.util.List;

import com.beauty1nside.accnut.dto.AssetDTO;
import com.beauty1nside.accnut.dto.AssetSearchDTO;

public interface AssetMapper {

	AssetDTO info(String assetsCode);
	List<AssetDTO> list(AssetSearchDTO dto);
	int count(AssetSearchDTO dto);
	int insert(AssetDTO dto);
}
