package com.beauty1nside.hr.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class EmployeeDTO {
	private Long employeeNum;		// 사원 고유번호 (PK)
	private String employeeName;	// 사원 이름
	private String ssn;				// 주민등록번호 (암호화 저장 필요)
	private String email;		    // 이메일 주소 (유효성 체크 필요)
	private String phone;			// 연락처 (전화번호 형식 검증 필요)
	
	private Date hireDate;			// 입사일
	private Date quitDate; 			// 퇴사일 (퇴사 처리 시 입력)
	
	private Long departmentNum;		// 부서 번호 (FK: HR_DEPARTMENT)
	private String position;		// 직급 (공통코드: P0001)
	private String autority;		// 권한 (공통코드: AU001)
	private String status;			// 재직 상태 (공통코드: ST001)
	private String employmentType;	// 근무 유형 (공통코드: ET001)
	
	private String address;			// 주소
	private String zipCode;			// 우편번호
	
	private String bankName;		// 급여 지급 은행명
	private String accountNum;		// 계좌번호 (암호화 저장 필요)
	
	private String profileImage;	// 프로필 이미지 경로
	private String memo;			// 메모
	
	private Date registerDate;		// 등록일 (sysdate)
	private Date updateDate;		// 최종 수정일 (sysdate)
	
}
