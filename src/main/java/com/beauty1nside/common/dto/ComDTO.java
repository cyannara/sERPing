package com.beauty1nside.common.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * ERP 사용 회사 정보를 담는 페이지
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

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ComDTO {
	private int companyNum;
	private String companyName;
	private String companyEngName;
	private String representationName;
	private String representationPhone;
	private String chargerName;
	private String chargerPhone;
	private String chargerEmail;
	private String companyAddress;
	private String businessNum;
	private String businessLicense;
	private String serviceState;
	private Date registerDate;
}
