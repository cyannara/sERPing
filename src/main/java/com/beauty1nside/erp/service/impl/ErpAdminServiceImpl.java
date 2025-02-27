package com.beauty1nside.erp.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.beauty1nside.common.dto.ComDTO;
import com.beauty1nside.common.mapper.ErpComMapper;
import com.beauty1nside.erp.dto.CompanyListDTO;
import com.beauty1nside.erp.dto.CustomerServiceDTO;
import com.beauty1nside.erp.dto.ErpSearchDTO;
import com.beauty1nside.erp.dto.ServiceReturnDTO;
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
 *  2025.02.25  표하연          회사의 구독현황을 조회한다 [ServiceReturnDTO]
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
     * PasswordEncoder 비밀번호 암호화 코드 주입
     */
	private final PasswordEncoder passwordEncoder;
	
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
     * @param ErpSearchListDTO
     * @return List<CompanyListDTO>
     */
	@Override
	@Transactional	// 트랜잭션 적용: 실행 중 예외 발생 시 롤백, 정상 종료 시 커밋
	public List<CompanyListDTO> companyList(ErpSearchDTO searchDTO) {
		return erpAdminMapper.companyList(searchDTO);
	}

	/**
     * ERP 사용 회사 전체 리스트 갯수를 조회
     *
     * @param ErpSearchListDTO
     * @return int
     */
	@Override
	@Transactional
	public int getCount(ErpSearchDTO searchDTO) {
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
		return erpAdminMapper.comenname(companyEngName) >= 1 ? true : false;
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
		cominfo.setCompanyAddress(passwordEncoder.encode(cominfo.getCompanyEngName())); //스프링 기본제공 함호화 이용암호화
		erpAdminMapper.insertuseraccount(cominfo);
		
		//회사 구독기간 서비스
		erpAdminMapper.insertservice(cominfo.getCompanyNum());
		
		//회사 CS 내역 남기기
		CustomerServiceDTO csDTO = new CustomerServiceDTO();
		csDTO.setCompanyNum(cominfo.getCompanyNum());
		csDTO.setEmployeeNum(employeeNum);
		csDTO.setCustomerServiceContent(customerServiceContent);
		csDTO.setCustomerServiceDivision(customerServiceDivision);
		
		return erpAdminMapper.insertNewCS(csDTO) >= 1 ? true : false;
	}

	/**
     * ERP 사용 회사의 cs 내역을 남긴다
     *
     * @param CustomerServiceDTO
     * @return boolean
     */
	@Override
	public boolean insertNewCS(CustomerServiceDTO csDTO) {
		return erpAdminMapper.insertNewCS(csDTO) >= 1 ? true : false;
	}

	/**
     * ERP 사용회사의 서비스 기간을 변경한다
     *
     * @param Map<String, Object>
     * @return boolean
     */
	@Override
	@Transactional
	public boolean updateServiceInfo(Map<String, Object> requestData) {
		
		int remainingDays = ((Number) requestData.get("remainingDays")).intValue();
		
		//문의 내역을 남김
	    CustomerServiceDTO customerServiceDTO = new CustomerServiceDTO();
	    customerServiceDTO.setCompanyNum( (Integer)requestData.get("companyNum") );
	    customerServiceDTO.setEmployeeNum( (Integer)requestData.get("employeeNum") );
	    String servicecontent = """
	    		[서비스기간변경]
	    		""";
	    servicecontent += remainingDays+"추가 \n";
	    servicecontent += "[사유] : " + (String)requestData.get("customerServiceContent");
	    customerServiceDTO.setCustomerServiceDivision( (String)requestData.get("customerServiceDivision") );
	    customerServiceDTO.setCustomerServiceContent( servicecontent );
	    log.info("Mapped DTO: " + customerServiceDTO.toString());
	    erpAdminMapper.insertNewCS(customerServiceDTO);
	    
	    if(remainingDays <= -10) {
		    //회사 서비스 상태를 변경함
		    ComDTO comdto = new ComDTO();
		    comdto.setCompanyNum( (Integer)requestData.get("companyNum") );
		    comdto.setServiceState("EC03");
		    erpAdminMapper.updateCompnayInfo(comdto);
	    }
	    
	    //서비스 기간을 변경함
		return erpAdminMapper.updateServiceInfo(requestData) >= 1 ? true : false;
	}
	
	/**
     * ERP 사용회사 성보를 변경한다
     *
     * @param ComDTO
     * @return boolean
     */
	@Override
	public boolean updateCompnayInfo(ComDTO comDTO) {
		return false;
	}

	/**
     * ERP 사용회사의 서비스 기간을 변경한다 (전체 서비스)
     *
     * @param Map<String, Object>
     * @return boolean
     */
	@Override
	@Transactional
	public boolean allUpdateServiceInfo(Map<String, Object> requestData) {
		
		//문의 내역을 남김
	    CustomerServiceDTO customerServiceDTO = new CustomerServiceDTO();
	    customerServiceDTO.setCompanyNum( (Integer)requestData.get("companyNum") );
	    customerServiceDTO.setEmployeeNum( (Integer)requestData.get("employeeNum") );
	    String servicecontent = """
	    		[서비스상태변경]
	    		""";
	    servicecontent += "[변경상태] : "+(String)requestData.get("serviceState")+"\n";
	    servicecontent += "[기존] : "+(String)requestData.get("subscriptionEndDate")+"\n";
	    
	    // 오늘 날짜 + 10일 계산
	    LocalDate futureDate = LocalDate.now().plusDays(9);
	    String updatedDate = futureDate.toString(); // "YYYY-MM-DD" 형식
	    
	    if ("EC03".equals(requestData.get("serviceState"))) {
	    	servicecontent += "[변경] : 1010-10-10\n";
	    	updatedDate = "1010-10-10";
	    	//기본서비스 제외 모든 서비스를 삭제한다
		    erpAdminMapper.ServiceDelete(requestData);
	    }else {
	    	servicecontent += "[변경] : " + updatedDate + "\n";
	    }
	    
	    servicecontent += "[사유] : " + (String)requestData.get("customerServiceContent");
	    customerServiceDTO.setCustomerServiceDivision( (String)requestData.get("customerServiceDivision") );
	    customerServiceDTO.setCustomerServiceContent( servicecontent );
	    log.info("Mapped DTO: " + customerServiceDTO.toString());
	    erpAdminMapper.insertNewCS(customerServiceDTO);
	    
	    //회사 서비스 상태를 변경함
	    ComDTO comdto = new ComDTO();
	    comdto.setCompanyNum( (Integer)requestData.get("companyNum") );
	    comdto.setServiceState((String)requestData.get("serviceState"));
	    erpAdminMapper.updateCompnayInfo(comdto);
	    
	    requestData.put("subscriptionEndDate", updatedDate);
	    
	    //구독 정보를 변경
		return erpAdminMapper.allUpdateServiceInfo(requestData) >= 1 ? true : false;
	}

	/**
     * ERP 사용회사 정보를 상황에 맞게 등록 또는 업데이트 한다
     *
     * @param ComDTO
     * @param String
     * @param String
     * @param int
     * @return boolean
     */
	@Override
	public boolean upsertCompanyInfo(ComDTO dto, String customerServiceDivision, String customerServiceContent,
			int employeeNum) {

		//회사 CS 내역 남기기
		CustomerServiceDTO csDTO = new CustomerServiceDTO();
		csDTO.setCompanyNum(dto.getCompanyNum());
		csDTO.setEmployeeNum(employeeNum);
		csDTO.setCustomerServiceContent(customerServiceContent);
		csDTO.setCustomerServiceDivision(customerServiceDivision);
		erpAdminMapper.insertNewCS(csDTO);
		
		//회사 정보 수정
		return erpAdminMapper.upsertCompanyInfo(dto) >= 1 ? true : false;
	}

	/**
     * ERP 사용회사 비밀번호를 초기화 한다
     *
     * @param int
     * @return boolean
     */
	@Override
	public boolean pwReSet(Map<String, Object> requestData) {
		
		//회사 CS 내역 남기기
		CustomerServiceDTO csDTO = new CustomerServiceDTO();
		csDTO.setCompanyNum((int)requestData.get("companyNum"));
		csDTO.setEmployeeNum((int)requestData.get("employeeNum"));
		String customerServiceContent = "[비밀번호초기화] \n";
		customerServiceContent += "[사유] " + (String)requestData.get("customerServiceContent");
		csDTO.setCustomerServiceContent(customerServiceContent);
		csDTO.setCustomerServiceDivision((String)requestData.get("customerServiceDivision"));
		erpAdminMapper.insertNewCS(csDTO);
				
		//비밀번호 초기화 하기
		ComDTO comdto = erpComMapper.comnum((int)requestData.get("companyNum"));
		comdto.getCompanyEngName();
		String employeePw = passwordEncoder.encode(comdto.getCompanyEngName()); //스프링 기본제공 함호화 이용암호화
		return erpAdminMapper.pwReSet(employeePw, (int)requestData.get("companyNum")) == 1 ? true : false;
	}

	/**
     * ERP 사용회사 cslist를 조회한다
     *
     * @param int
     * @return List<CustomerServiceDTO>
     */
	@Override
	public List<CustomerServiceDTO> csList(int companyNum) {
		return erpAdminMapper.csList(companyNum);
	}

	/**
     * ERP 사용회사 처리된 구독 정보를 조회한다
     *
     * @param int
     * @return ServiceReturnDTO
     */
	@Override
	public List<ServiceReturnDTO> serviceReturninfo(int companyNum) {
		return erpAdminMapper.serviceReturninfo(companyNum);
	}
}
