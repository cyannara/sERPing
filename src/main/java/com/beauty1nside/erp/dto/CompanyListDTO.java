package com.beauty1nside.erp.dto;

import java.time.LocalDate;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ERP 회사 전체 리스트 데이터를 가져옴
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
@AllArgsConstructor
@NoArgsConstructor
public class CompanyListDTO {
	
	/**
     * ERP 회사 전체 리스트 데이터 DTO
     */
	private int companyNum;               // 회사 번호
    private String companyName;           // 회사명
    private String companyEngName;        // 회사 영문명
    private String representationName;    // 대표자명
    private String representationPhone;   // 대표자 전화번호
    private String chargerName;           // 담당자명
    private String chargerPhone;          // 담당자 전화번호
    private String chargerEmail;          // 담당자 이메일
    private String companyAddress;        // 회사 주소
    private String businessNum;           // 사업자 등록번호
    private String businessLicense;       // 사업자 면허
    private String serviceState;          // 서비스 상태
    private Date registerDate;       // 등록 날짜

    private int contractNum;              // 계약서 번호
    private int subscriptionNum;          // 구독 번호
    private LocalDate subscriptionEndDate; // 구독 종료일
    private String subscriptionForm;      // 구독 형태

}
