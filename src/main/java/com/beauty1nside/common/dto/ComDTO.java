package com.beauty1nside.common.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * ERP 사용 회사 정보를 담는 페이지
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
@NoArgsConstructor
@AllArgsConstructor
public class ComDTO {
	private int companyNum;	//회사번호
	private String companyName;	//회사명
	private String companyEngName;	//회사영문명
	private String representationName;	//대표자명
	private String representationPhone;	//대표자연락처
	private String chargerName;		//담당자명
	private String chargerPhone;	//담당자연락처
	private String chargerEmail;	//이메일
	private String companyAddress;	//회사주소
	private String businessNum;		//시업자번호
	private String businessLicense;	//등록증파일주소
	private String serviceState;
	private Date registerDate;
	private int employeeNum;
}
