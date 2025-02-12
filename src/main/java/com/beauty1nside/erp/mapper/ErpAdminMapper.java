package com.beauty1nside.erp.mapper;

import java.util.List;

import com.beauty1nside.erp.dto.CompanyListDTO;
import com.beauty1nside.erp.dto.CompanyListSearchDTO;
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
     * @param CompanyListSearchDTO
     * @return List<CompanyListDTO>
     */
	public List<CompanyListDTO> companyList(CompanyListSearchDTO searchDTO);
	
	/**
     * ERP 사용 회사 전체 리스트 갯수를 조회
     *
     * @param CompanyListSearchDTO
     * @return int
     */
	public int getCount(CompanyListSearchDTO searchDTO);
}
