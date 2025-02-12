package com.beauty1nside.accnut.service;

import java.util.List;

import com.beauty1nside.accnut.dto.AssetDTO;

public interface AssetService {
	AssetDTO info(String assetsCode);
	List<AssetDTO> list();
}
