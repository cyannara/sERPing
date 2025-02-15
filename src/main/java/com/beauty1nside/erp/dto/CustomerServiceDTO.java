package com.beauty1nside.erp.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ERP 사용 업체들의 모든 문의 내용을 저장하는 DTO
 * @author ERP 관리자 개발팀 표하연
 * @since 2025.02.14
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 *   수정일      수정자          수정내용
 *  -------    --------    ---------------------------
 *  2025.02.14  표하연          최초 생성
 *
 *  </pre>
*/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomerServiceDTO {
	
	private int customerServiceNum;
	private int companyNum;
	private int employeeNum;
	private String customerServiceDivision;
	private String customerServiceContent;
	private Date customerServiceDate;
	
	private String employeeName;

}
