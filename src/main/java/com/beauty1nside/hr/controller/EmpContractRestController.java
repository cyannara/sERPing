package com.beauty1nside.hr.controller;

import java.io.InputStream;
import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.beauty1nside.hr.dto.EmpContractDTO;
import com.beauty1nside.hr.service.EmpContractService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

@Log4j2
@RestController
@AllArgsConstructor
@RequestMapping("/hr/rest")
public class EmpContractRestController {
	
	// db커넥션 풀
	@Autowired
	DataSource datasource;
	
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
    @GetMapping("/contract/report")
    public void contractReport(
    		@RequestParam("employeeNum") Long employeeNum,
    		 HttpServletRequest request, HttpServletResponse response) throws Exception {
    	
    	 InputStream jasperStream = getClass().getResourceAsStream("/reports/hr/empContract.jasper");
    	 
 	    Map<String, Object> params = new HashMap<>();
 	    params.put("p_employeeNum", employeeNum);

	    Connection conn = datasource.getConnection();
	    JasperPrint jasperPrint = JasperFillManager.fillReport(jasperStream, params, conn);
	    conn.close();

	    response.setContentType(MediaType.APPLICATION_PDF_VALUE);
	    JasperExportManager.exportReportToPdfStream(jasperPrint, response.getOutputStream());
    }
    
    @GetMapping("/contract/report/down")
	public void contractreportDown(
			@RequestParam("employeeNum") Long employeeNum,
	        HttpServletRequest request, HttpServletResponse response
	        ) throws Exception {
	    InputStream jasperStream = getClass().getResourceAsStream("/reports/hr/empContract.jasper");
	    
	    Map<String, Object> params = new HashMap<>();
 	    params.put("p_employeeNum", employeeNum);
	    
	    Connection conn = datasource.getConnection();
	    JasperPrint jasperPrint = JasperFillManager.fillReport(jasperStream, params, conn);
	    conn.close();
	    
	    response.setContentType(MediaType.APPLICATION_PDF_VALUE);
	    // 다운로드를 위한 헤더 설정: attachment; filename="파일명.pdf"
	    response.setHeader("Content-Disposition", "attachment; filename=\"근로계약서_" + employeeNum + ".pdf\"");
	    JasperExportManager.exportReportToPdfStream(jasperPrint, response.getOutputStream());
	}
    

}
