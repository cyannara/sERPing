package com.beauty1nside.erp.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 불특정 다수의 문의에 대한 답변을 저장하는 DTO
 * @author ERP 관리자 개발팀 표하연
 * @since 2025.03.03
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 *   수정일      수정자          수정내용
 *  -------    --------    ---------------------------
 *  2025.03.03  표하연          최초 생성
 *
 *  </pre>
*/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ErpAnswerDTO {
	private int answerNum;       // 답변 번호
    private int inquiryNum;      // 문의 번호 (외래 키)
    private int employeeNum;     // 직원 번호 (외래 키)
    private String employeeName;     // 직원 번호 (외래 키)
    private String answerContent; // 답변 내용
    private Date answerDate; // 답변 날짜
}
