package com.beauty1nside.erp.mapper;

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
public interface ErpAdminLoginMapper {
	/**
     * ERP 사용회사 사원 로그인
     *
     * @param String
     * @param String
     * @return ErpEmployeeDTO
     */
	public ErpEmployeeDTO loginConfig(@Param("employeeId") String employeeId);
}
