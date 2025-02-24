package com.beauty1nside.erp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * ERP 사용회사의 결제목록 상세를 가져옴
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
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class SubscriptionDetailDTO extends ErpSubOptionDTO {
    private String subscriptionTailNum;
    private String subscriptionNum;
    //private String subscriptionOptionNum;
    
}
