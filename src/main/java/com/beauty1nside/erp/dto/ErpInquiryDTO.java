package com.beauty1nside.erp.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 불특정 다수의 문의 정보를 저장할 수있는 DTO
 * @author ERP 관리자 개발팀 표하연
 * @since 2025.03.02
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 *   수정일      수정자          수정내용
 *  -------    --------    ---------------------------
 *  2025.03.02  표하연          최초 생성
 *
 *  </pre>
*/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ErpInquiryDTO {
	private int inquiryNum;
    private String companyName;
    private String chargerName;
    private String chargerPhone;
    private String chargerEmail;
    private String inquiryContent;
    private Date inquiryDate;
    private int cntInquiry; // 답변 개수 추가
}
