package com.beauty1nside.hr.service.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.beauty1nside.hr.dto.DeptDTO;
import com.beauty1nside.hr.mapper.DeptMapper;
import com.beauty1nside.hr.service.DeptService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service // ★이거 무조건 넣어!!
//@AllArgsConstructor	//모든필드를 생성자 초기화 한다
@RequiredArgsConstructor // 파이널 붙어 있는 필드만 초기화 해준다
//필드 하나뿐이면 그냥 all 하고 여러개이면 Required
public class DeptServiceImpl implements DeptService {

	private final DeptMapper deptMapper;
	
    @Override
    public List<DeptDTO> list(Long companyNum) {
        return deptMapper.list(companyNum);
    }

    @Override
    public DeptDTO getCompanyInfo(Long companyNum) {

        return deptMapper.getCompanyInfo(companyNum);
    }
    
    
    @Override
    public Map<String, Object> getOrganization(Long companyNum) {
        // 1️⃣ DB에서 모든 부서 조회
        List<DeptDTO> departments = deptMapper.list(companyNum);
        DeptDTO companyInfo = deptMapper.getCompanyInfo(companyNum);  // 회사 정보 조회

        Map<Long, DeptDTO> deptMap = new HashMap<>();
        for (DeptDTO dept : departments) {
            deptMap.put(dept.getDepartmentNum(), dept);
            dept.setTotalEmployeeCount(dept.getEmployeeCount()); // 기본값 설정
        }

        // 2️⃣ 하위 부서 직원 수를 상위 부서에 더함
        for (DeptDTO dept : departments) {
            if (dept.getParentDepartmentNum() != null) {
                DeptDTO parentDept = deptMap.get(dept.getParentDepartmentNum());
                if (parentDept != null) {
                    parentDept.setTotalEmployeeCount(
                        parentDept.getTotalEmployeeCount() + dept.getTotalEmployeeCount()
                    );
                }
            }
        }

        // 3️⃣ 최상위 레벨(회사)의 직원 수 계산
        int totalEmployeeCount = departments.stream()
            .filter(d -> d.getParentDepartmentNum() == null)
            .mapToInt(DeptDTO::getTotalEmployeeCount)
            .sum();
        companyInfo.setTotalEmployeeCount(totalEmployeeCount);

        // 4️⃣ 반환 데이터 구성
        Map<String, Object> result = new HashMap<>();
        result.put("company", companyInfo);
        result.put("departments", departments);
        return result;
    }

    @Override
    public int insertDepartment(DeptDTO dept) {
        return deptMapper.insertDepartment(dept);
    }
    

}
