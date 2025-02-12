package com.beauty1nside.common.mapper;

import com.beauty1nside.common.dto.ComDTO;

/**
 * ERP 사용 회사 정보 맵퍼 호출함
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

public interface ErpComMapper {
	/**
     * 회사 번호 이용 회사 정보를 가져오는 DTO
     *
     * @param ComDTO
     * @return
     */
	public ComDTO comnum(int companyNum);
	
	/**
     * 회사 코드 이용 회사 정보를 가져오는 DTO
     *
     * @param ComDTO
     * @return
     */
	public ComDTO comcode(String companyEngName);
}
