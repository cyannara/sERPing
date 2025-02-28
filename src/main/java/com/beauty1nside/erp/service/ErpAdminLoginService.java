package com.beauty1nside.erp.service;

import org.apache.ibatis.annotations.Param;

import com.beauty1nside.erp.dto.ErpEmployeeDTO;

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
public interface ErpAdminLoginService {
	/**
     * ERP 사용회사 사원 로그인
     *
     * @param String
     * @return ErpEmployeeDTO
     */
	public ErpEmployeeDTO loginConfig(String employeeId);
	
	/**
     * 로그인 할 수있는 계정이 있는지 갯수를 확인한다
     *
     * @param String
     * @return boolean
     */
	public boolean loginCount(@Param("employeeId") String employeeId);
}
