package com.beauty1nside.hr.service.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.beauty1nside.hr.dto.EmpDTO;
import com.beauty1nside.hr.dto.EmpSearchDTO;
import com.beauty1nside.hr.mapper.EmpMapper;
import com.beauty1nside.hr.service.EmpService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service // ★이거 무조건 넣어!!
//@AllArgsConstructor	//모든필드를 생성자 초기화 한다
@RequiredArgsConstructor // 파이널 붙어 있는 필드만 초기화 해준다
//필드 하나뿐이면 그냥 all 하고 여러개이면 Required
public class EmpServiceImpl implements EmpService {

	private final EmpMapper empMapper;

	@Override
	public EmpDTO info(Long employeeNum) {
		// TODO Auto-generated method stub
		return empMapper.info(employeeNum);
	}

	@Override
	public List<EmpDTO> list(EmpSearchDTO dto) {
		// TODO Auto-generated method stub
		return empMapper.list(dto);
	}

	@Override
	public int count(EmpSearchDTO dto) {
		// TODO Auto-generated method stub
		return empMapper.count(dto);
	}

	@Override
    public Map<String, Object> getCommonCodes() {
        Map<String, Object> codes = new HashMap<>();
        codes.put("departments", empMapper.getDepartments());
        codes.put("positions", empMapper.getPositions());
        codes.put("employmentTypes", empMapper.getEmploymentTypes());
        codes.put("statuses", empMapper.getStatuses());
        return codes;
    }

}
