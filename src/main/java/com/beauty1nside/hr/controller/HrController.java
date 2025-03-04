package com.beauty1nside.hr.controller;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.beauty1nside.hr.dto.EmpDTO;
import com.beauty1nside.hr.dto.EmpSearchDTO;
import com.beauty1nside.hr.service.DeptService;
import com.beauty1nside.hr.service.EmpService;

import groovy.util.logging.Log4j2;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;

@Log4j2
@Controller
@AllArgsConstructor
@RequestMapping("/hr/*")
public class HrController {
	private final EmpService empService;
	private final DeptService deptService;
	
	//샘플 페이지
	@GetMapping("/")
	public String sample() {
		return "/hr/sample";
	};
	
//	----------------------------------------------------------------------------	
	
	  @ModelAttribute
	  public void setAttributes(Model model) {
	    model.addAttribute("menu", "hr");
	  }
	
	//인사관리-사원정보관리
	@GetMapping("/employee")
	public String employee(@ModelAttribute EmpSearchDTO searchDTO, Model model) {
	    List<EmpDTO> empList = empService.list(new EmpSearchDTO());  // 전체 리스트 조회
	    model.addAttribute("employeeList", empList);  // 리스트를 모델에 추가
	    return "hr/employee";
	}
	
	  //인사관리-조직도조회
		@GetMapping("/organization_list")
		public String getOrganizationList(HttpSession session, Model model) {
		    // ✅ 세션에서 companyNum 가져오기
		    Long sessionCompanyNum = (Long) session.getAttribute("companyNum");

		    // ✅ 세션에 companyNum이 없을 경우 예외 처리
		    if (sessionCompanyNum == null) {
		        return "redirect:/login"; // 로그인 페이지로 리다이렉트
		    }

		    // ✅ 세션에서 가져온 companyNum으로 조직도 조회
		    Map<String, Object> organization = deptService.getOrganization(sessionCompanyNum);
		    model.addAttribute("company", organization.get("company"));
		    model.addAttribute("departments", organization.get("departments"));
		    return "hr/organization_list";
		}
    
  //인사관리-조직도관리
	@GetMapping("/organization")
	public String getOrganization(HttpSession session, Model model) {
	    // ✅ 세션에서 companyNum 가져오기
	    Long sessionCompanyNum = (Long) session.getAttribute("companyNum");

	    // ✅ 세션에 companyNum이 없을 경우 예외 처리
	    if (sessionCompanyNum == null) {
	        return "redirect:/login"; // 로그인 페이지로 리다이렉트
	    }

	    // ✅ 세션에서 가져온 companyNum으로 조직도 조회
	    Map<String, Object> organization = deptService.getOrganization(sessionCompanyNum);
	    System.out.println("📌 조직도 데이터: " + organization);
	    model.addAttribute("company", organization.get("company"));
	    model.addAttribute("departments", organization.get("departments"));
	    return "hr/organization";
	}


    
  //인사관리-인사발령관리 
	@GetMapping("/emp_change")
	public String emp_change() {
		return "hr/emp_change";
	};
    
  //인사관리-근로계약관리
	@GetMapping("/emp_contract")
	public String emp_contract() {
		return "hr/emp_contract";
	};
	
	  //인사관리-근로계약관리
		@GetMapping("/emp_contract_list")
		public String emp_contract_list() {
			return "hr/emp_contract_list";
		};
	
    
  //근태관리-출퇴근기록관리
	@GetMapping("/attendance")
	public String attendance() {
		return "hr/attendance";
	};
    
  //근태관리-출장외근관리 business_trip
	@GetMapping("/business_trip")
	public String business_trip() {
		return "hr/business_trip";
	};
    
  //연차관리-연차요청관리
	@GetMapping("/leave_approval")
	public String leave_approval() {
		return "hr/leave_approval";
	};
    
  //연차관리-연차사용내역조회
	@GetMapping("/leave_status")
	public String leave_status() {
		return "hr/leave_status";
	};
    
  //급여관리-급여지급상태
	@GetMapping("/payroll_status")
	public String payroll_status() {
		return "hr/payroll_status";
	};
    
  //급여관리-급여명세서조회
	@GetMapping("/pay_slip")
	public String pay_slip() {
		return "hr/pay_slip";
	};
    
  //증명서관리-증명서 승인반려
	@GetMapping("/cert_approval")
	public String cert_approval() {
		return "hr/cert_approval";
	};
    
  //증명서-증명서 다운로드
	@GetMapping("/cert_download")
	public String cert_download() {
		return "hr/cert_download";
	};


}
