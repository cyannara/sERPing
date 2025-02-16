package com.beauty1nside.erp.dto;

import java.time.LocalDate;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ERP제공 회사의 사원정보를 담는 DTO
 * @author ERP 관리자 개발팀 표하연
 * @since 2025.02.16
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
@AllArgsConstructor
@NoArgsConstructor
public class ErpEmployeeDTO {
	private int employeeNum;      // 사원 고유번호 (PK)
    private String employeeId;     // 사원 ID
    private String employeePw;     // 비밀번호
    private String employeeName;   // 사원 이름
    private String department;     // 부서
    private String position;       // 직위
    private String job;            // 직무
    private Date birthday;    // 생년월일
    private String phone;          // 전화번호
    private String email;          // 이메일
    private String address;        // 주소
    private Date hireDate;    // 입사일
    private Date retirementDate; // 퇴사일
    private String workState;      // 근무 상태
    private Date updateDate;  // 정보 수정 날짜
    private Date registerDate;// 등록 날짜
}
