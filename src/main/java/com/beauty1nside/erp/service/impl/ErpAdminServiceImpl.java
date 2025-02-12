package com.beauty1nside.erp.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.beauty1nside.erp.dto.CompanyListDTO;
import com.beauty1nside.erp.dto.testDTO;
import com.beauty1nside.erp.mapper.ErpAdminMapper;
import com.beauty1nside.erp.service.ErpAdminService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

/**
 * ERP 회사 관리자 관련 정보 CURD 서비스 Impl
 * @author ERP 관리자 개발팀 표하연
 * @since 2025.02.12
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 *   수정일      수정자          수정내용
 *  -------    --------    ---------------------------
 *  2025.02.12  표하연          최초 생성
 *
 *  </pre>
*/
@Log4j2
@Service	//★이거 무조건 넣어!!
//@AllArgsConstructor	//모든필드를 생성자 초기화 한다
@RequiredArgsConstructor //파이널 붙어 있는 필드만 초기화 해준다
//필드 하나뿐이면 그냥 all 하고 여러개이면 Required
public class ErpAdminServiceImpl implements ErpAdminService {

	/**
     * ErpAdminMapper 맵퍼를 사용하기 위한 의존성 주입
     */
	private final ErpAdminMapper erpAdminMapper;
	
	/**
     * DB연결 확인을 위하여 샘플 데이터를 조회
     *
     * @return testDTO
     */
	//@Transactional 어노테이션 용도와 활용 알아보기
	@Override
	@Transactional	// 트랜잭션 적용: 실행 중 예외 발생 시 롤백, 정상 종료 시 커밋
	public List<testDTO> test() {
		return erpAdminMapper.test();
	}

	/**
     * ERP 사용 회사 전체 리스트를 조회한다
     *
     * @return List<CompanyListDTO>
     */
	@Override
	@Transactional	// 트랜잭션 적용: 실행 중 예외 발생 시 롤백, 정상 종료 시 커밋
	public List<CompanyListDTO> companyList() {
		return erpAdminMapper.companyList();
	}
}
