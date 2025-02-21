package com.beauty1nside.accnut.service.Impl;

import org.springframework.stereotype.Service;

import com.beauty1nside.accnut.mapper.JsonQueryMapper;
import com.beauty1nside.accnut.service.JsonQueryService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;


@Log4j2
@Service	//★이거 무조건 넣어!!
//@AllArgsConstructor	//모든필드를 생성자 초기화 한다
@RequiredArgsConstructor //파이널 붙어 있는 필드만 초기화 해준다
//필드 하나뿐이면 그냥 all 하고 여러개이면 Required
public class JsonQueryServiceImpl implements JsonQueryService {
	
	final JsonQueryMapper jsonQueryMapper;
	
	@Override
	public String jsonTest() {
		// TODO Auto-generated method stub
		return jsonQueryMapper.jsonTest();
	}
}
