package com.beauty1nside.erp.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.beauty1nside.common.dto.ComDTO;
import com.beauty1nside.erp.dto.CompanyListDTO;
import com.beauty1nside.erp.dto.ContactRequestDTO;
import com.beauty1nside.erp.dto.CustomerServiceDTO;
import com.beauty1nside.erp.dto.ErpSearchDTO;
import com.beauty1nside.erp.dto.ServiceReturnDTO;
import com.beauty1nside.erp.dto.testDTO;

/**
 * ERP 회사 관리자 관련 정보 CURD 맵퍼
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
 *  2025.02.28  표하연          불특정 다수의 문의들 등록 한다
 *
 *  </pre>
*/
public interface ErpAdminMapper {
	/**
     * DB연결 확인을 위하여 샘플 데이터를 조회
     *
     * @return testDTO
     */
	public List<testDTO> test();
	
	/**
     * ERP 사용 회사 전체 리스트를 조회한다
     *
     * @param ErpSearchListDTO
     * @return List<CompanyListDTO>
     */
	public List<CompanyListDTO> companyList(ErpSearchDTO searchDTO);
	
	/**
     * ERP 사용 회사 전체 리스트 갯수를 조회
     *
     * @param ErpSearchListDTO
     * @return int
     */
	public int getCount(ErpSearchDTO searchDTO);
	
	/**
     * 신규회사 등록시 회사 코드 중복 확인
     *
     * @param String
     * @return int
     */
	public int comenname(String companyEngName);
	
	/**
    * ERP 신규회사 정보를 등록한다
    *
    * @param ComDTO
    * @return int
    */
	public int insertCompany(ComDTO comdto);
	
	/**
    * ERP 신규회사 최고관리자 계정을 등록한다
    *
    * @param ComDTO
    * @return int
    */
	public int insertuseraccount(ComDTO comdto);
	
	/**
    * ERP 신규회사의 구독기간 서비스
    *
    * @param int
    * @return int
    */
	public int insertservice(int companyNum);
	
	/**
     * ERP 사용 회사 cs를 남긴다
     *
     * @param ErpSearchListDTO
     * @return List<CompanyListDTO>
     */
	public int insertNewCS(CustomerServiceDTO csDTO);
	
	/**
     * ERP 사용회사의 서비스 기간을 변경한다 (특정 서비스만)
     *
     * @param Map<String, Object>
     * @return int
     */
	public int updateServiceInfo(Map<String, Object> requestData);
		
	/**
     * ERP 사용회사의 서비스 기간을 변경한다 (모든 서비스)
     *
     * @param Map<String, Object>
     * @return int
     */
	public int allUpdateServiceInfo(Map<String, Object> requestData);
	
	/**
     * ERP 사용회사 그룹웨서 서비스를 초기화 시킨다
     *
     * @param Map<String, Object>
     * @return int
     */
	public int gropServiceUpdate(Map<String, Object> requestData);
	
	/**
     * ERP 사용회사 기본서비스 제외 모든구독을 삭제 시킴
     *
     * @param Map<String, Object>
     * @return int
     */
	public int ServiceDelete(Map<String, Object> requestData);
	
	/**
     * ERP 사용회사 성보를 변경한다
     *
     * @param ComDTO
     * @return int
     */
	public int updateCompnayInfo(ComDTO comDTO);
	
	/**
     * ERP 사용회사 정보를 상황에 맞게 등록 또는 업데이트 한다
     *
     * @param ComDTO
     * @return int
     */
	public int upsertCompanyInfo(ComDTO dto);
	
	/**
     * ERP 사용회사 비밀번호를 초기화 한다
     *
     * @param String
     * @param int
     * @return int
     */
	public int pwReSet(@Param("employeePw") String employeePw, @Param("companyNum") int companyNum);
	
	/**
     * ERP 사용회사 cslist를 조회한다
     *
     * @param int
     * @return List<CustomerServiceDTO>
     */
	public List<CustomerServiceDTO> csList(int companyNum);
	
	/**
     * ERP 사용회사 처리된 구독 정보를 조회한다
     *
     * @param int
     * @return List<ServiceReturnDTO>
     */
	public List<ServiceReturnDTO> serviceReturninfo(int companyNum);
	
	/**
     * 불특정 다수의 문의를 수집한다
     *
     * @param CustomerServiceDTO
     * @return int
     */
	public int insertNewQuery(ContactRequestDTO dto);
}
