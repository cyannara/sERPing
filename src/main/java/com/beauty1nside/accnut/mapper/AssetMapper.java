package com.beauty1nside.accnut.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.beauty1nside.accnut.dto.AssetDTO;
import com.beauty1nside.accnut.dto.AssetSearchDTO;

public interface AssetMapper {

	AssetDTO info(@Param("assetsName")String assetsName, @Param("companyNum")int companyNum);
	List<AssetDTO> list(AssetSearchDTO dto);
	int count(AssetSearchDTO dto);
	int insert(AssetDTO dto);
}
