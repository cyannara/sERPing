package com.beauty1nside.erp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 현재미사용
 * @author ERP 관리자 개발팀 표하연
 * @since 2025.02.14
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 *   수정일      수정자          수정내용
 *  -------    --------    ---------------------------
 *  2025.02.14  표하연          최초 생성
 *
 *  </pre>
*/
@Controller
@RequestMapping("/erp/modal")
public class ErpAdminModalController {
	
	//@GetMapping("/businessLicenseModel")
    public String getBusinessLicenseModel() {
        return "erp/modal/businessLicenseModel"; // templates/erp/modal/businessLicenseModel.html 로 연결됨
    }

}
