package com.beauty1nside.erp.dto;

import java.time.LocalDate;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 구독 결제한 현금영수증, 세금계산서 데이터 처리에 사용되는 DTO
 * @author ERP 관리자 개발팀 표하연
 * @since 2025.02.26
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 *   수정일      수정자          수정내용
 *  -------    --------    ---------------------------
 *  2025.02.26  표하연          최초 생성
 *
 *  </pre>
*/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TaxInvoiceDTO {
	private int billNum;          // 시퀀스
	private int subscriptionNum;  // 구독 번호
	private int employeeNum;      // 제공자 번호 이거나 수요자 번호이거나 상태별 상이
	private String billForm;         // EB01=현금영수증, EB02=세금계산서 [EB]
	private String pdfAddress;       // PDF 파일 주소
	private String issueCompany;     // EI01=erp수요사 / EI02=erp공급사 [EI]
	private String companyCode;   // 발행 회사 코드
    private Date issueDate;     // 발행일
    
    private int companyNum;	//회사번호 쓰는데 없음
}