package com.beauty1nside.erp.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.beauty1nside.erp.dto.ErpSubOptionDTO;
import com.beauty1nside.erp.dto.erpSubscriptionInfoListDTO;

/**
 * ERP 사용 회사 CRUD 하는 맵퍼 클래스
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
public interface ErpUserMapper {

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
	
	/**
     * 구독목록(결제헤더)를 등록한다
     *
     * @param Map<String, Object>
     * @return int
     */
	public int prosubscriptionlist(Map<String, Object> map);
	
	/**
     * 구독목록(결제헤더)의 마지막 결제 기본키를 가져온다
     *
     * @param Map<String, Object>
     * @return int
     */
	public int lastpaykey(Map<String, Object> map);
	
	/**
     * 구독목록 결제 옵션 정보를 저장한다
     *
     * @param int
     * @param int
     * @return int
     */
	public int prosubscriptiontail(@Param("subscriptionNum") int subscriptionNum, @Param("subscriptionOptionNum") int subscriptionOptionNum);
	
	/**
     * 구독 옵션 정보를 가져온다 단일 레코드
     *
     * @param int
     * @return ErpSubOptionDTO
     */
	public ErpSubOptionDTO lastoptionlist(int subscriptionOptionNum);
	
	/**
     * 회사가 현재 구독중인 정보 확인
     *
     * @param int
     * @param int
     * @param int
     * @return erpSubscriptionInfoListDTO
     */
	public erpSubscriptionInfoListDTO subinfo(@Param("companyNum") int companyNum, @Param("subnamenum1") int subnamenum1, @Param("subnamenum2") int subnamenum2);
	
}
