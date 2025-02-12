package com.beauty1nside.erp.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.beauty1nside.erp.dto.testDTO;
import com.beauty1nside.erp.mapper.ErpAdminMapper;
import com.beauty1nside.erp.service.ErpAdminService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service	//★이거 무조건 넣어!!
//@AllArgsConstructor	//모든필드를 생성자 초기화 한다
@RequiredArgsConstructor //파이널 붙어 있는 필드만 초기화 해준다
//필드 하나뿐이면 그냥 all 하고 여러개이면 Required
public class ErpAdminServiceImpl implements ErpAdminService {

	private final ErpAdminMapper erpAdminMapper;
	
	//@Transactional 어노테이션 용도와 활용 알아보기
	@Override
	@Transactional	// 이게 다해줌 (트렌젝션 으로 모두 처리했을경우만 진행되게 해줌)
	public List<testDTO> test() {
		return erpAdminMapper.test();
	}
}
