package com.beauty1nside.accnut.service.Impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.beauty1nside.accnut.dto.AssetDTO;
import com.beauty1nside.accnut.dto.AssetSearchDTO;
import com.beauty1nside.accnut.mapper.AssetMapper;
import com.beauty1nside.accnut.service.AssetService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service	//★이거 무조건 넣어!!
//@AllArgsConstructor	//모든필드를 생성자 초기화 한다
@RequiredArgsConstructor //파이널 붙어 있는 필드만 초기화 해준다
//필드 하나뿐이면 그냥 all 하고 여러개이면 Required
public class AssetServiceImpl implements AssetService{
	
		private final AssetMapper assetMapper;
		
		@Override
		public AssetDTO info(String assetsCode) {
			// TODO Auto-generated method stub
			return assetMapper.info(assetsCode);
		}
		
		@Override
		public List<AssetDTO> list(AssetSearchDTO dto) {
		// TODO Auto-generated method stub
		return assetMapper.list(dto);
		}
		
		@Override
		public int count(AssetSearchDTO dto) {
		// TODO Auto-generated method stub
		return assetMapper.count(dto);
		}
		
		@Override
		public int insert(AssetDTO dto) {
		// TODO Auto-generated method stub
		return assetMapper.insert(dto);
		}
}		

