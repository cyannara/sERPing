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
@Alias("DeptDTO")  // 별칭 추가
public class DepartmentDTO {

    private Long departmentNum;      // 부서 고유 번호 (PK)
    private String departmentCode;   // 부서 코드 (규칙 기반 생성)
    private String departmentName;   // 부서 이름
    private Long parentDepartmentNum;// 상위 부서 번호 (NULL이면 최상위 부서)
    private String departmentType;   // 부서 유형 (DT001 기본값)
    private Long managerNum;         // 부서장 (사원 번호)
    private String departmentStatus; // 부서 상태 (공통코드: DU)
    private Date registerDate;       // 등록일
    private Date updateDate;         // 수정일
    private Long companyNum;         // 소속 회사 번호
}
