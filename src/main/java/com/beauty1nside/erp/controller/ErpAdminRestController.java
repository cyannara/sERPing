package com.beauty1nside.erp.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.beauty1nside.common.GridArray;
import com.beauty1nside.common.Paging;
import com.beauty1nside.common.dto.ComDTO;
import com.beauty1nside.common.mapper.ErpComMapper;
import com.beauty1nside.erp.dto.CustomerServiceDTO;
import com.beauty1nside.erp.dto.ErpSearchDTO;
import com.beauty1nside.erp.dto.testDTO;
import com.beauty1nside.erp.service.ErpAdminService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

/**
 * ERP 회사 관리 사용하는 정보를 CURD 처리하여 REST API형태로 출력한다
 * @author ERP 관리자 개발팀 표하연
 * @since 2025.02.12
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 *   수정일      수정자          수정내용
 *  -------    --------    ---------------------------
 *  2025.02.12  표하연          최초 생성
 *  2025.02.13  표하연          회사영문명(코드명) 중복검사, 회사등록, 검색페이징
 *  2025.02.15  표하연          회사정보 수정 및 문의 처리
 *
 *  </pre>
*/
@Log4j2
@RestController	//★★★
@AllArgsConstructor
@RequestMapping("/erp/rest/*")
public class ErpAdminRestController {
	
	/**
     * ErpAdminMapper 맵퍼를 사용하기 위한 의존성 주입 {서비스}
     */
	private final ErpAdminService erpAdminService;
	
	/**
     * 회사정보 [단건] 조회하는 의존성 주입 {맵퍼}
     */
	private final ErpComMapper erpComMapper;
	
	/**
     * DB연결 확인을 위하여 샘플 데이터를 조회
     *
     * @return List<testDTO>
     */
	@GetMapping("/list")
	public List<testDTO> getlist(){
		List<testDTO> list = erpAdminService.test();
		log.info(list.toString());
		return list;
	}
	
	/**
     * ERP 사용 회사 전체 리스트 조회
     * 2025-02-14 11:00 시훈이 페이징 모듈로 변경
     *
     * @param int
     * @param ErpSearchDTO
     * @param Paging
     * @return Object
     * @throws JsonMappingException
     * @throws JsonProcessingException
     */
	@GetMapping("/comlist")
	public Object comlist( 
				@RequestParam(name = "perPage", defaultValue = "5", required = false) int perPage,
				@RequestParam(name = "page", defaultValue = "1", required = false) int page,
				ErpSearchDTO dto,
				Paging paging
			) throws JsonMappingException, JsonProcessingException{

		//한페이지에 몇개 나오게 할껀지
		paging.setPageUnit(perPage);
		
		// 현재 페이지 셋팅
		paging.setPage(page);		
		//log.info("★★★"+paging.getPage());

		// 페이징 조건
		dto.setStart(paging.getFirst());
		dto.setEnd(paging.getLast());
		
		// 페이징처리
		paging.setTotalRecord(erpAdminService.getCount(dto));
		
		// grid 배열 처리
		GridArray grid = new GridArray();
		Object result = grid.getArray( paging.getPage(), paging.getTotalRecord(), erpAdminService.companyList(dto) );
		return result;
	}
	
	
	/**
     * DB연결 확인을 위하여 샘플 데이터를 조회
     *
     * @return String
     */
	@GetMapping("/info")
	public String info(){
		//회사 정보 단건 가져오는 샘플
		ComDTO info = erpComMapper.comnum(5);
		log.info(info.toString());
		ComDTO info2 = erpComMapper.comcode("oliveyoung");
		log.info(info2.toString());
		return "OK";
	}
	
	/**
     * 회사 코드를 중복 검사한다
     * @param companyEngName
     * @return boolean
     */
	@GetMapping("/comenname/{companyEngName}")
	public boolean comenname(@PathVariable(name="companyEngName") String companyEngName) {
		log.info(erpAdminService.comenname(companyEngName));
		return erpAdminService.comenname(companyEngName); 
	}
	
	/**
     * 회사 서비스 상태를 변경 한다
     * @param Map<String, Object>
     * @return String
     */
	@PostMapping("/serviceToggle")
	public String serviceToggle(@RequestBody Map<String, Object> requestData) {
		
		log.info("requestData Map: " + requestData.toString());
		
		Boolean isBoolean = erpAdminService.allUpdateServiceInfo(requestData);
	    if(isBoolean) {
	    	return "OK";
	    }else {
	    	return "NO";
	    }
	}
	
	/**
     * 회사 서비스 기간을 변경 한다
     * @param Map<String, Object>
     * @return String
     */
	@PostMapping("/serviceChange")
	public String serviceChange(@RequestBody Map<String, Object> requestData) {
		
		log.info("requestData Map: " + requestData.toString());
		
		Boolean isBoolean = erpAdminService.updateServiceInfo(requestData);
	    if(isBoolean) {
	    	return "OK";
	    }else {
	    	return "NO";
	    }
	}
	
	/**
     * 회사 단순문의를 처리한다
     * @param Map<String, Object>
     * @return String
     */
	@PostMapping("/cs")
	public String cs(@RequestBody Map<String, Object> requestData) {
		//맵객체 DTO로 자동변환
		ObjectMapper objectMapper = new ObjectMapper();
	    CustomerServiceDTO customerServiceDTO = objectMapper.convertValue(requestData, CustomerServiceDTO.class);

	    log.info("Mapped DTO: " + customerServiceDTO.toString());
	    Boolean isBoolean = erpAdminService.insertNewCS(customerServiceDTO);
	    if(isBoolean) {
	    	return "OK";
	    }else {
	    	return "NO";
	    }
	}
	
	/**
     * 회사를 신규등록한다
     * @param Map<String, Object>
     * @return String
     */
	@PostMapping("/newcomapny")
	public String register(@RequestBody Map<String, Object> requestData) {
		
		log.info("Received requestData: " + requestData.toString());

	    ObjectMapper objectMapper = new ObjectMapper();
	    
	    //칼럼이 과하게 많은경우 칼럼을 제거하고 dto에 넣으면된다
//	    // DTO이용해서 맵 하나 초기화 안의 데이터 가져오기
//	    Map<String, Object> dtoMap = (Map<String, Object>) requestData.get("dto");
//
//	    // DTO에 없는 불필요한 필드 제거
//	    dtoMap.remove("customerServiceDivision");
//	    dtoMap.remove("customerServiceContent");
//		ComDTO dto = objectMapper.convertValue(dtoMap, ComDTO.class);	    

	    // ComDTO로 변환
	    ComDTO dto = objectMapper.convertValue(requestData.get("dto"), ComDTO.class);

	    // 추가 필드 가져오기
	    String customerServiceDivision = (String) requestData.get("customerServiceDivision");
	    String customerServiceContent = "";
	    int employeeNum = (int) requestData.get("employeeNum");

	    customerServiceContent += """
	    		[신규 업체 등록]
	    		
	    		
	    		""" + (String) requestData.get("customerServiceContent");
	    // 로그 출력 (정상적으로 변환되었는지 확인)
	    log.info("DTO: " + dto.toString());
	    log.info("customerServiceDivision: " + customerServiceDivision);
	    log.info("customerServiceContent: " + customerServiceContent);
	    log.info("employeeNum: " + employeeNum);
	    
	    //회사 등록
	    Boolean isBoolean = erpAdminService.insertCompany(dto, customerServiceDivision, customerServiceContent, employeeNum);
	    if(isBoolean) {
	    	return "OK";
	    }else {
	    	return "NO";
	    }
	}
	
	/**
     * 회사 정보 변경에 따른 알맞은 업데이트를 한다
     * @param Map<String, Object>
     * @return String
     */
	@PostMapping("/upsertcompnay")
	public String upsertcompnay(@RequestBody Map<String, Object> requestData) {
		
		log.info("Received requestData: " + requestData.toString());

	    ObjectMapper objectMapper = new ObjectMapper();
	    
	    ComDTO dto = objectMapper.convertValue(requestData.get("dto"), ComDTO.class);
	    ComDTO cominfo = erpComMapper.comnum(dto.getCompanyNum());
	    if (dto.getBusinessLicense() == null || dto.getBusinessLicense().isEmpty()) {
	    	dto.setBusinessLicense(cominfo.getBusinessLicense());
	    }
	    log.info("DTO: " + dto.toString());
	    
	    // 추가 필드 가져오기
	    String customerServiceDivision = (String) requestData.get("customerServiceDivision");
	    String customerServiceContent = "";
	    int employeeNum = (int) requestData.get("employeeNum");
	    customerServiceContent += """
	    		[업체정보수정]
	    		""";
	    customerServiceContent += "[기존] " + cominfo.toString() + "\n";
	    customerServiceContent += "[변경] " + dto.toString() + "\n";
	    customerServiceContent += "[사유] " + (String) requestData.get("customerServiceContent");
	    log.info("customerServiceDivision: " + customerServiceDivision);
	    log.info("customerServiceContent: " + customerServiceContent);
	    log.info("employeeNum: " + employeeNum);
	    
	    //정보수정
	    Boolean isBoolean = erpAdminService.upsertCompanyInfo(dto, customerServiceDivision, customerServiceContent, employeeNum);
	    if(isBoolean) {
	    	return "OK";
	    }else {
	    	return "NO";
	    }
	}
	
	/**
     * ERP사용 회사의 비밀번호를 초기화 한다
     * @param Map<String, Object>
     * @return String
     */
	@PostMapping("/pwReSet")
	public String pwReSet(@RequestBody Map<String, Object> requestData) {
		log.info("Received requestData: " + requestData.toString());
		
		//정보수정
	    Boolean isBoolean = erpAdminService.pwReSet(requestData);
	    if(isBoolean) {
	    	return "OK";
	    }else {
	    	return "NO";
	    }
	}
	
	/**
     * ERP사용 회사의 CS리스트를 조회한다
     * @param Map<String, Object>
     * @return List<CustomerServiceDTO>
     */
	@PostMapping("/csList")
	public List<CustomerServiceDTO> csList(@RequestBody Map<String, Object> requestData) {
		log.info("Received requestData: " + requestData.toString());
		
		List<CustomerServiceDTO> cslist =  erpAdminService.csList((int)requestData.get("companyNum"));
		return cslist;
	}
	
	/**
     * 사업자 등록증 이미지를 서버에 저장한다 [사용중지 FTP서버변경하려고]
     * 미사용 FTPFileUploadController.java에서 처리중
     * 
     * @param MultipartFile
     * @return ResponseEntity<Map<String, Object>>
     */
	//@PostMapping("/uploadBusinessLicense")
    public ResponseEntity<Map<String, Object>> uploadFile(@RequestParam("file") MultipartFile file) {
        Map<String, Object> response = new HashMap<>();
        
        String UPLOAD_DIR = "C:/atest/";
       
        try {
            if (file.isEmpty()) {
                response.put("success", false);
                response.put("message", "업로드할 파일이 없습니다.");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
            }

            // 파일 저장
            File saveFile = new File(UPLOAD_DIR + file.getOriginalFilename());
            file.transferTo(saveFile);

            response.put("success", true);
            response.put("message", "파일 업로드 성공");
            response.put("fileName", file.getOriginalFilename());

            return ResponseEntity.ok(response);
        } catch (IOException e) {
            e.printStackTrace();  // 콘솔에 오류 출력
            response.put("success", false);
            response.put("message", "파일 저장 중 오류 발생: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        } catch (Exception e) {
            e.printStackTrace();
            response.put("success", false);
            response.put("message", "예상치 못한 오류 발생: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
 
}
