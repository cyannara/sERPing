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

import com.beauty1nside.common.Paging;
import com.beauty1nside.common.dto.ComDTO;
import com.beauty1nside.common.mapper.ErpComMapper;
import com.beauty1nside.erp.dto.CompanyListSearchDTO;
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
 *  2025.02.13  표하연          회사영문명(코드명) 중복검사, 회사등록
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
     *
     * @param int
     * @param CompanyListSearchDTO
     * @param Paging
     * @return Map<String, Object>
     * @throws JsonMappingException
     * @throws JsonProcessingException
     */
	@GetMapping("/comlist")
	public Map<String, Object> comlist( 
										@RequestParam(name = "perPage", defaultValue = "5", required = false) int perPage,
										CompanyListSearchDTO searchDTO,
										Paging paging
			) throws JsonMappingException, JsonProcessingException{
		
		//한페이지에 몇개 나오게 할껀지
		paging.setPageUnit(perPage);
		
		//log.info("★★★"+paging.getPage());

		// 페이징 조건
		searchDTO.setStart(paging.getFirst());
		searchDTO.setEnd(paging.getLast());
		
		// 페이징처리
		paging.setTotalRecord(erpAdminService.getCount(searchDTO));
		
		String str = """
								{
				  "result": true,
				  "data": {
				    "contents": [],
				    "pagination": {
				      "page": 1,
				      "totalCount": 100
				    }
				  }
				}
								""";
		ObjectMapper objectMapper = new ObjectMapper();
		//위에 내용을 맵으로 바꾸는거
		Map<String, Object> map = objectMapper.readValue(str, Map.class);
		//맵으로 바꾼거에서 data 읽어내고
		Map<String, Object> data = (Map) map.get("data");
		//페이지 네이션 읽어내고
		Map<String, Object> pagination = (Map) data.get("pagination");
		
		//거기에 전체 페이지랑 페이지번호 읽어옴
		// 페이징처리
		pagination.put("page", paging.getPage());
		pagination.put("totalCount", paging.getTotalRecord());
		//pagination.put("totalCount", erpAdminService.getCount(searchDTO));
	
		//log.info(searchDTO.toString());
		data.put("contents", erpAdminService.companyList(searchDTO));
		//log.info(map.toString());
		return map;
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
	    String customerServiceContent = (String) requestData.get("customerServiceContent");
	    int employeeNum = (int) requestData.get("employeeNum");

	    customerServiceContent = """
	    		[신규 업체 등록]
	    		
	    		
	    		""" + customerServiceContent;
	    // 로그 출력 (정상적으로 변환되었는지 확인)
	    log.info("DTO: " + dto.toString());
	    log.info("customerServiceDivision: " + customerServiceDivision);
	    log.info("customerServiceContent: " + customerServiceContent);
	    log.info("employeeNum: " + employeeNum);
	    
	    //이제 이값들로 인서트 투닥투닥 처리하면 됨
	    //이미지파일은 어떻게 처리되는지 봐야함

	    return "OK";
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
