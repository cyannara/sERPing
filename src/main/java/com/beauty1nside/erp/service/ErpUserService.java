package com.beauty1nside.erp.service;

import java.util.List;

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
     * 회사 인사인원 확인
     *
     * @param int
     * @return int
     */
	public int hrlist(int companyNum);

}
