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
public class DeptDTO {

    private Long departmentNum;      // 부서 고유 번호 (PK)
    private String departmentName;   // 부서 이름
    private Long parentDepartmentNum;// 상위 부서 번호 (NULL이면 최상위 부서)
    private String departmentType;   // 부서 유형 (DT001 기본값)
    private Long managerNum;         // 부서장 (사원 번호)
    private String departmentStatus; // 부서 상태 (공통코드: DU)
    private Date registerDate;       // 등록일
    private Date updateDate;         // 수정일
    private Long companyNum;         // 소속 회사 번호
    private String companyName;
    private String companyEngName;
    private Integer employeeCount; 
    private Integer totalEmployeeCount; // 하위 부서 포함 직원 수
    
    
}
