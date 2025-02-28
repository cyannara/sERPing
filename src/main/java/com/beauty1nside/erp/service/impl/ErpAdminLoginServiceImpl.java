package com.beauty1nside.erp.service.impl;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.beauty1nside.common.mapper.ErpComMapper;
import com.beauty1nside.erp.dto.ErpEmployeeDTO;
import com.beauty1nside.erp.mapper.ErpAdminLoginMapper;
import com.beauty1nside.erp.mapper.ErpAdminMapper;
import com.beauty1nside.erp.service.ErpAdminLoginService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

/**
 * ERP 회사 관리자 로그인 처리
 * @author ERP 관리자 개발팀 표하연
 * @since 2025.02.16
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 *   수정일      수정자          수정내용
 *  -------    --------    ---------------------------
 *  2025.02.16  표하연          최초 생성
 *
 *  </pre>
*/
@Log4j2
@Service	//★이거 무조건 넣어!!
//@AllArgsConstructor	//모든필드를 생성자 초기화 한다
@RequiredArgsConstructor //파이널 붙어 있는 필드만 초기화 해준다
//필드 하나뿐이면 그냥 all 하고 여러개이면 Required
public class ErpAdminLoginServiceImpl implements ErpAdminLoginService{
	
	/**
     * ErpAdminLoginMapper 맵퍼를 사용하기 위한 의존성 주입
     */
	private final ErpAdminLoginMapper erpAdminLoginMapper;
	
	/**
     * ERP 사용회사 사원 로그인
     *
     * @param String
     * @return ErpEmployeeDTO
     */
	@Override
	public ErpEmployeeDTO loginConfig(String employeeId) {
		return erpAdminLoginMapper.loginConfig(employeeId);
	}

	/**
     * 로그인 할 수있는 계정이 있는지 갯수를 확인한다
     *
     * @param String
     * @return boolean
     */
	@Override
	public boolean loginCount(String employeeId) {
		return erpAdminLoginMapper.loginCount(employeeId) >= 1 ? true:false;
	}

}
