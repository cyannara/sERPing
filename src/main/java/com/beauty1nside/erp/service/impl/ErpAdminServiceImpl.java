package com.beauty1nside.erp.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.beauty1nside.common.dto.ComDTO;
import com.beauty1nside.common.mapper.ErpComMapper;
import com.beauty1nside.erp.dto.CompanyListDTO;
import com.beauty1nside.erp.dto.CompanyListSearchDTO;
import com.beauty1nside.erp.dto.CustomerServiceDTO;
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
 *  2025.02.13  표하연          회사영문코드 중복처리
 *  2025.02.14  표하연          회사신규등록(회사,cs,최고관리자,구독정보목록생성)
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
     * ErpComMapper 맵퍼를 사용하기 위한 의존성 주입 (회사코드, 회사번호 조회)
     */
	private final ErpComMapper erpComMapper;
	
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
     * @param CompanyListSearchDTO
     * @return List<CompanyListDTO>
     */
	@Override
	@Transactional	// 트랜잭션 적용: 실행 중 예외 발생 시 롤백, 정상 종료 시 커밋
	public List<CompanyListDTO> companyList(CompanyListSearchDTO searchDTO) {
		return erpAdminMapper.companyList(searchDTO);
	}

	/**
     * ERP 사용 회사 전체 리스트 갯수를 조회
     *
     * @param CompanyListSearchDTO
     * @return int
     */
	@Override
	@Transactional
	public int getCount(CompanyListSearchDTO searchDTO) {
		return erpAdminMapper.getCount(searchDTO);
	}

	/**
     * 신규회사 등록시 회사 코드 중복 확인
     *
     * @param String
     * @return boolean
     */
	@Override
	public boolean comenname(String companyEngName) {
		return erpAdminMapper.comenname(companyEngName) == 1 ? true : false;
	}

	/**
    * ERP 신규회사 정보를 등록한다
    *
    * @param ComDTO
    * @param String
    * @param String
    * @return boolean
    */
	@Override
	@Transactional
	public boolean insertCompany(ComDTO comdto, String customerServiceDivision, String customerServiceContent, int employeeNum) {
		
		//회사 등록
		erpAdminMapper.insertCompany(comdto);
		
		//등록된 회사정보를 읽어옴
		ComDTO cominfo = erpComMapper.comcode(comdto.getCompanyEngName());
		//cominfo.getCompanyNum(); [회사번호]
		
		//회사 정보 이용 최고 관리자 계정생성
		cominfo.setCompanyAddress(cominfo.getCompanyEngName()); //해당부분 암호화 해서 여기 넣기
		erpAdminMapper.insertuseraccount(cominfo);
		
		//회사 구독기간 서비스
		erpAdminMapper.insertservice(cominfo.getCompanyNum());
		
		//회사 CS 내역 남기기
		CustomerServiceDTO csDTO = new CustomerServiceDTO();
		csDTO.setCompanyNum(cominfo.getCompanyNum());
		csDTO.setEmployeeNum(employeeNum);
		csDTO.setCustomerServiceContent(customerServiceContent);		
		
		return erpAdminMapper.insertNewCS(csDTO) == 1 ? true : false;
	}
}
