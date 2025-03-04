package com.beauty1nside.erp.dto;

import lombok.Data;
import lombok.ToString;

/**
 * ERP 관련 페이지 네이션을 위한 기초 데이터
 * @author ERP 관리자 개발팀 표하연
 * @since 2025.02.14
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 *   수정일      수정자          수정내용
 *  -------    --------    ---------------------------
 *  2025.02.14  표하연          최초 생성
 *
 *  </pre>
*/
@Data
@ToString(callSuper = true)  // 부모 클래스 필드도 toString()에 포함
public class ErpSearchDTO extends ErpSearchListDTO {
	int start;
	int end;
	int pageUnit;
}
