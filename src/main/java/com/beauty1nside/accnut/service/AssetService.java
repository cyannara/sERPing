package com.beauty1nside.accnut.service;

import java.util.List;

import com.beauty1nside.accnut.dto.AssetDTO;
import com.beauty1nside.accnut.dto.AssetSearchDTO;

public interface AssetService {
	AssetDTO info(String assetsCode);
	List<AssetDTO> list(AssetSearchDTO dto);
	int count(AssetSearchDTO dto);
}
