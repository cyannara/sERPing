package com.beauty1nside.erp.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ERP 사용회사의 결제목록을 가져옴
 * @author ERP 관리자 개발팀 표하연
 * @since 2025.02.21
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 *   수정일      수정자          수정내용
 *  -------    --------    ---------------------------
 *  2025.02.21  표하연          최초 생성
 *
 *  </pre>
*/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SubScriptionDTO {
	private int subscriptionNum; // 구독 번호
    private int companyNum; // 회사 번호
    private String companyName; // 회사명
    private int employeeNum; // 직원 번호
    private String subscriptionForm; // 구독 형태 코드
    private String subscriptionFormName; // 구독 형태명
    private String subscriptionMean; // 구독 수단 코드
    private String subscriptionMeanName; // 구독 수단명
    private int subscriptionAmount; // 구독 금액
    private String state; // 상태 코드
    private String stateName; // 상태명
    private Date subscriptionDate; // 구독 날짜
    
    //현금영수증 또는 세금계산서
    private int billNum;         // 거래명세서 번호
    private String billForm;      // 거래명세서 양식
    private String billFormName;      // 거래명세서 양식
    private String pdfAddress;    // PDF 주소
    private String issueCompany;  // 발행 회사
    private String issueCompanyName;  // 발행 회사
    private String companyCode;   // 회사 코드
    private Date issueDate;  // 발행 날짜
}
