package com.beauty1nside.erp.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ERP 사용회사 처리된 구독 정보를 담는 DTO
 * 관리자페이지에서 사용
 * @author ERP 관리자 개발팀 표하연
 * @since 2025.02.25
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 *   수정일      수정자          수정내용
 *  -------    --------    ---------------------------
 *  2025.02.25  표하연          최초 생성
 *
 *  </pre>
*/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ServiceReturnDTO {
	private int subscriptionNameNum;
    private String subscriptionName;
    private int subscriptionOptionNum;
    private String subscriptionOption;
    private String subscriptionForm;
    private int limitDay;
    private Date subscriptionEndDate;
}
