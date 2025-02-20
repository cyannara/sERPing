package com.beauty1nside.erp.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ERP 사용회사의 계약서 정보를 담는 DTO
 * @author ERP 관리자 개발팀 표하연
 * @since 2025.02.20
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 *   수정일      수정자          수정내용
 *  -------    --------    ---------------------------
 *  2025.02.20  표하연          최초 생성
 *
 *  </pre>
*/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ContractDTO {
	private int contractNum;          // 계약 번호
    private int companyNum;           // 회사 번호
    private String erpContractDocument; // 전자 계약 문서
    private Date erpRegisterDate; // 계약 등록 날짜
    private String contract1;
    private String contract2;
    private String contract3;
    private String contract4;
    private String contract5;
    private String contract6;
    private String contract7;
    private String contract8;
    private String contract9;
    private String contract10;
    private String contract11;
    private String contract12;
    private String contract13;
    private String contract14;
    private String contract15;
    private String contract16;
    private String contract17;
    private String contract18;
    private String contract19;
    private String contract20;
    private String contract21;
    private String contract22;
    private String contract23;
    private String contract24;
    private String contract25;
    private String contract26;
    private String contract27;
    private String contract28;
    private String contract29;
    private String contract30;
}
