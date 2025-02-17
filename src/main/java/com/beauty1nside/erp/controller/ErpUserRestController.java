package com.beauty1nside.erp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.beauty1nside.erp.dto.erpSubscriptionInfoListDTO;
import com.beauty1nside.erp.service.ErpUserService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

/**
 * ERP 사용 회사 REST 컨트롤러
 * @author ERP 관리자 개발팀 표하연
 * @since 2025.02.17
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 *   수정일      수정자          수정내용
 *  -------    --------    ---------------------------
 *  2025.02.17  표하연          최초 생성
 *  2025.02.18  표하연          결제 모듈 등록
 *
 *  </pre>
*/
@Log4j2	//log4j 가 안되면 버전높은 log4j2 사용
@RestController
//@AllArgsConstructor
@RequestMapping("/erp/rest/*")
public class ErpUserRestController {
	
	/**
     * ErpUserService 서비스를 사용하기 위한 의존성 주입
     */
	@Autowired
	private ErpUserService erpUserService;
	
	/**
     * 고객 구독 정보를 받아옴
     *
     * @param int
     * @return List<erpSubscriptionInfoListDTO>
     */
	@GetMapping("/subList/{compnayNum}")
	public List<erpSubscriptionInfoListDTO> subList(@PathVariable(name="compnayNum") int compnayNum){
		log.info("aaaaaaaaaa "+compnayNum);
		return erpUserService.sublist(compnayNum);
	}
	
	/**
     * 회사 인사인원 확인
     *
     * @param int
     * @return int
     */
	@GetMapping("/hrlist/{compnayNum}")
	public int hrlist(@PathVariable(name="compnayNum") int compnayNum){
		log.info("bbbbbbb "+compnayNum);
		return erpUserService.hrlist(compnayNum);
	}
	
	/**
     * 프로퍼티에서 결제키를 가져온다
     *
     */
	private final String impKey;
	public ErpUserRestController(
            ErpUserService erpUserService, 
            @Value("${portone.api.key}") String impKey) {
        this.erpUserService = erpUserService;
        this.impKey = impKey;
    }
	/**
     * 결제키를 반환 해준다
     *
     * @return Map<String, String>
     */
	@GetMapping("/get-imp-key")
	public Map<String, String> getImpKey() {
        Map<String, String> response = new HashMap<>();
        response.put("impKey", impKey);
        return response;
    }
	
}
