package com.beauty1nside.erp.dto;

import java.time.LocalDate;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 현재 구독 상태를 저장하는 DTO
 * @author ERP 관리자 개발팀 표하연
 * @since 2025.02.17
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 *   수정일      수정자          수정내용
 *  -------    --------    ---------------------------
 *  2025.02.17  표하연          최초 생성
 *
 *  </pre>
*/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class erpSubscriptionInfoListDTO {
	private int subscriptionNum;          // 구독 번호 (PK)
    private int companyNum;               // 회사 번호 (FK)
    private String subscriptionForm;       // 구독 형태
    private int subscriptionNameNum;      // 구독명 번호
    private int subscriptionOptionNum;    // 구독 옵션 번호
    private Date subscriptionEndDate; // 구독 종료일
    private Date subscriptionUpdateDate; // 구독 갱신일
}
