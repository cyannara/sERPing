package com.beauty1nside.erp.service;

import java.util.List;
import java.util.Map;

import com.beauty1nside.erp.dto.erpSubscriptionInfoListDTO;

/**
 * ERP 사용 회사 CRUD 하는 서비스 인터페이스
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
 *  2025.02.18  표하연          기간 구독 결제 서비스 생성
 *
 *  </pre>
*/
public interface ErpUserService {
	
	/**
     * 고객 구독 정보를 받아옴
     *
     * @param int
     * @return List<erpSubscriptionInfoListDTO>
     */
	public List<erpSubscriptionInfoListDTO> sublist(int comapnyNum); 
	
	/**
     * 회사 계약 상태 여부를 내보냄
     *
     * @param int
     * @return int
     */
	public int subcontact(int comapnyNum);
	
	/**
     * 회사 인사인원 확인
     *
     * @param int
     * @return int
     */
	public int hrlist(int companyNum);
	
	/**
     * 기간 구독 서비스를 등록한다
     *
     * @param Map<String, Object>
     * @return int
     */
	public int periodservicepay(Map<String, Object> requestData);
	
	/**
     * 그룹웨어 옵션 정보를 불러온다
     *
     * @param int
     * @return int
     */
	public int gpoptioninfo(int comapnyNum);

}
