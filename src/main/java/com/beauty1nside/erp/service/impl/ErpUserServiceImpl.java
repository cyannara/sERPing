package com.beauty1nside.erp.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.beauty1nside.erp.dto.erpSubscriptionInfoListDTO;
import com.beauty1nside.erp.mapper.ErpUserMapper;
import com.beauty1nside.erp.service.ErpUserService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

/**
 * ERP 사용 회사 CRUD 하는 서비스 클래스
 * @author ERP 관리자 개발팀 표하연
 * @since 2025.02.17
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 *   수정일      수정자          수정내용
 *  -------    --------    ---------------------------
 *  2025.02.17  표하연          최초 생성
 *
 *  </pre>
*/
@Log4j2
@Service	//★이거 무조건 넣어!!
//@AllArgsConstructor	//모든필드를 생성자 초기화 한다
@RequiredArgsConstructor //파이널 붙어 있는 필드만 초기화 해준다
//필드 하나뿐이면 그냥 all 하고 여러개이면 Required
public class ErpUserServiceImpl implements ErpUserService {

	/**
     * ErpUserMapper 맵퍼를 사용하기 위한 의존성 주입
     */
	private final ErpUserMapper erpUserMapper;
	
	/**
     * 고객 구독 정보를 받아옴
     *
     * @param int
     * @return List<erpSubscriptionInfoListDTO>
     */
	@Override
	public List<erpSubscriptionInfoListDTO> sublist(int comapnyNum) {
		return erpUserMapper.sublist(comapnyNum);
	}

	/**
     * 회사 인사인원 확인
     *
     * @param int
     * @return int
     */
	@Override
	public int hrlist(int companyNum) {
		return erpUserMapper.hrlist(companyNum);
	}

}
