package com.beauty1nside.hr.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.beauty1nside.common.GridArray;
import com.beauty1nside.common.Paging;
import com.beauty1nside.hr.dto.EmpDTO;
import com.beauty1nside.hr.dto.EmpSearchDTO;
import com.beauty1nside.hr.service.EmpService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@AllArgsConstructor
@RequestMapping("/hr/rest")
public class HrRestController {
	final EmpService empService;
	final PasswordEncoder passwordEncoder;
	
	@GetMapping("/emp/list")
	public Object empList(@RequestParam(name = "perPage", defaultValue = "2", required = false) int perPage, 
			@RequestParam(name = "page", defaultValue = "1", required = false) int page, 
			@ModelAttribute EmpSearchDTO dto, @ModelAttribute  Paging paging) throws JsonMappingException, JsonProcessingException {
		
		
		log.info("📥 empList 호출됨");
	    log.info("🔍 검색 DTO 값: {}", dto);
	    
	    // ✅ 검색 조건이 올바르게 전달되는지 확인
	    log.info("🔎 searchType: {}", dto.getSearchType());
	    log.info("🔎 searchKeyword: {}", dto.getSearchKeyword());
		
		
		// 페이징 유닛 수
		paging.setPageUnit(perPage);
		paging.setPage(page);
		
		
		// 페이징 조건
		dto.setStart(paging.getFirst());
		dto.setEnd(paging.getLast());
		
		// 페이징 처리
	    int totalRecords = empService.count(dto);
	    paging.setTotalRecord(totalRecords);
		log.info("📊 총 레코드 수: {}", empService.count(dto));
		
		List<EmpDTO> empList = empService.list(dto);
		
		// grid 배열 처리
		GridArray grid = new GridArray();
		Object result = grid.getArray(paging.getPage(), totalRecords, empList);
		return result;
	}
	
    @GetMapping("/emp/common-codes")
    public ResponseEntity<Map<String, Object>> getCommonCodes() {
        Map<String, Object> result = empService.getCommonCodes();
        return ResponseEntity.ok(result);
    }	
    
    
    // 🔹 사원 등록 API
    @PostMapping("/emp/register")
    public ResponseEntity<String> registerEmployee(@RequestBody EmpDTO empDTO) {
    	
    	log.info("empDTO={}",empDTO);
    	log.info("ssnFirstPart={}",empDTO.getSsn());
    	
    	//ssn 합치기
    	String newSsn = empDTO.getFirstSsn()+"-"+empDTO.getSecondSsn();
    	newSsn = passwordEncoder.encode(newSsn);
    	empDTO.setSsn(newSsn);
    	
    	//비밀번호: 생년월일 8자리
    	String ssnFirstPart = empDTO.getFirstSsn();
    	log.info("ssnFirstPart={}",ssnFirstPart);
    	ssnFirstPart = passwordEncoder.encode(ssnFirstPart);
    	log.info("암호화한 ssnFirstPart={}",ssnFirstPart);
    	empDTO.setEmployeePw(ssnFirstPart);
    	
    	//주소 합치기
    	String newAddress = empDTO.getAddress()+"("+empDTO.getAddressDetail()+")";
    	empDTO.setAddress(newAddress);
    	
    	log.info("변경된 empDTO={}",empDTO);
        try {
            empService.registerEmployee(empDTO);
            return ResponseEntity.ok("사원 등록 성공! 사번: " + empDTO.getEmployeeId());
        } catch (Exception e) {
            log.error("❌ 사원 등록 실패: ", e);
            return ResponseEntity.status(500).body("사원 등록 실패");
        }
    }
    
    @GetMapping("/emp/new-employee-id")
    public ResponseEntity<String> getNewEmployeeId() {
        String newEmployeeId = empService.getNewEmployeeId(); // 새 사원번호 가져오기
        return ResponseEntity.ok(newEmployeeId);
    }
    
//    @GetMapping("/emp/departments")
//    public ResponseEntity<List<Map<String, Object>>> getDepartments() {
//        return ResponseEntity.ok(empService.getDepartmentList());
//    }


    // ✅ 새로운 전체 부서 목록 조회 (부서번호 + 부서이름 반환)
    @GetMapping("/emp/department-list")
    public ResponseEntity<List<Map<String, Object>>> getDepartmentList() {
        return ResponseEntity.ok(empService.getDepartmentList());
    }

    // ✅ 하위 부서 목록 조회
    @GetMapping("/emp/sub-departments")
    public ResponseEntity<List<Map<String, Object>>> getSubDepartments(@RequestParam("departmentNum") String departmentNum) {
        return ResponseEntity.ok(empService.getSubDepartments(departmentNum));
    }


}
