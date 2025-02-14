package com.beauty1nside.hr.dto;

import java.util.Date;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Alias("EmployeeDTO")  // 별칭 추가
public class EmpDTO {
    private Long employeeNum; // 사원번호
    private String employeeId; // 로그인 ID
    private String employeePw; // 비밀번호
    private String employeeName; // 사원 이름
    private String ssn; // 주민등록번호 (암호화 필요)
    private String email; // 이메일
    private String phone; // 연락처
    private Date hireDate; // 입사일
    private String position; // 직급 (공통코드: PO)
    private String authority; // 사원 권한 (공통코드: AU)
    private String status; // 재직 상태 (공통코드: ST)
    private Date quitDate; // 퇴사일
    private String address; // 주소
    private String zipCode; // 우편번호
    private String employmentType; // 근무 유형 (공통코드: ET)
    private String bankName; // 급여 지급 은행명
    private String accountNum; // 계좌번호 (암호화 필요)
    private String profileImage; // 프로필 이미지 경로
    private String memo; // 메모
    private Date registerDate; // 등록일
    private Date updateDate; // 수정일
    private Long companyNum; // 회사번호 (FK)
    private Long departmentNum; // 부서번호 (FK)
}
