package com.beauty1nside.hr.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.beauty1nside.hr.dto.EmpContractDTO;
import com.beauty1nside.hr.service.EmpContractService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@AllArgsConstructor
@RequestMapping("/hr/rest")
public class EmpContractRestController {
	final EmpContractService empContractService;
	
    /**
     * ✅ 근로계약 등록 API
     * @param contract 근로계약 정보
     * @return 성공 여부
     */
    @PostMapping("/contract/register")
    public ResponseEntity<String> registerContract(@RequestBody EmpContractDTO contract) {
        try {
            int result = empContractService.registerContract(contract);
            if (result > 0) {
                return ResponseEntity.ok("✅ 근로계약이 성공적으로 등록되었습니다.");
            } else {
                return ResponseEntity.badRequest().body("❌ 근로계약 등록 실패.");
            }
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("❌ 서버 오류 발생: " + e.getMessage());
        }
    }

    /**
     * ✅ 특정 사원의 최근 계약 조회 API
     * @param employeeNum 사원번호
     * @return EmpContractDTO (근로계약 정보)
     */
    @GetMapping("/constract/last/{employeeNum}")
    public ResponseEntity<EmpContractDTO> getLastContract(@PathVariable Long employeeNum) {
        EmpContractDTO contract = empContractService.getLastContract(employeeNum);
        if (contract != null) {
            return ResponseEntity.ok(contract);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * ✅ 전체 계약 목록 조회 API
     * @return 근로계약 목록
     */
    @GetMapping("/list")
    public ResponseEntity<List<EmpContractDTO>> getAllContracts() {
        List<EmpContractDTO> contracts = empContractService.getAllContracts();
        return ResponseEntity.ok(contracts);
    }

}
