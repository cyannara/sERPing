package com.beauty1nside.hr.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.beauty1nside.hr.dto.EmpDTO;
import com.beauty1nside.hr.dto.EmpSearchDTO;

@Mapper
public interface EmpMapper {
	
	EmpDTO info(Long employeeNum);
	List<EmpDTO> list(EmpSearchDTO dto);
	int count(EmpSearchDTO dto);
	
    List<String> getDepartments(); // 부서 목록
    List<Map<String, Object>> getDepartmentList(); // ✅ 새로 추가 (부서번호 + 부서이름 포함)
    List<Map<String, Object>> getSubDepartments(String departmentNum); // ✅ 하위 부서 조회 추가
    List<String> getPositions(); // 직급 목록
    List<Map<String, String>> getEmploymentTypes(); // 근무 유형 목록
    List<String> getStatuses(); // 재직 상태 목록
    List<String> getAuths(); // 권한 목록
    
    // 가장 최근 등록된 사원 ID 조회
    String getMaxEmployeeId(); 
    
    // 사원 등록
    void insertEmployee(EmpDTO empDTO);
    
    // 이메일 중복 체크 추가
    int checkEmailExists(String email);
    
    // 특정 부서의 사원 목록 가져오기 (부서 이름 포함)
    List<EmpDTO> listByDept(EmpSearchDTO dto);

    

}
