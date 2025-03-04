package com.beauty1nside.erp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 구독 정보를 보여준다
 * @author ERP 관리자 개발팀 표하연
 * @since 2025.03.04
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 *   수정일      수정자          수정내용
 *  -------    --------    ---------------------------
 *  2025.03.04  표하연          최초 생성
 *
 *  </pre>
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErpSubscriptionOptionDTO {

	private int subscriptionOptionNum;   // 구독 옵션 번호
    private int subscriptionNameNum;     // 구독 이름 번호
    private String subscriptionOption;    // 구독 옵션명
    private String subscriptionOptionPrice; // 구독 옵션 가격
    private Long subscriptionDiscount;    // 구독 할인율
    private int subscriptionPeriod;   // 구독 기간 (일 단위)
    private String subscriptionName;	//구독 상품명
}
