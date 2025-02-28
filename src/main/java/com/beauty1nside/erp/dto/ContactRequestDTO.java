package com.beauty1nside.erp.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ERP 사용 문의 정보를 담는 DTO
 * @author ERP 관리자 개발팀 표하연
 * @since 2025.02.28
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 *   수정일      수정자          수정내용
 *  -------    --------    ---------------------------
 *  2025.02.28  표하연          최초 생성
 *
 *  </pre>
*/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ContactRequestDTO {
	private int inquiryNum;
	private String companyName;
    private String chargerEmail;
    private String chargerName;
    private String chargerPhone;
    private String inquiryContent;
    private Date inquiryDate;
}
