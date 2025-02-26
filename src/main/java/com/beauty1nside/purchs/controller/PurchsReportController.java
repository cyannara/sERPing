package com.beauty1nside.purchs.controller;

import java.io.InputStream;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

@Log4j2	//log4j 가 안되면 버전높은 log4j2 사용
@Controller
@RequiredArgsConstructor
@RequestMapping("/purchs/report/*")
public class PurchsReportController {
	
	// db커넥션 풀
	@Autowired
	DataSource datasource;
	
	//pdf 읽기(발주서)
	@GetMapping("/report")
	public void report(
	        @RequestParam("companynum") int companynum, 
	        @RequestParam("purchasenum") long purchasenum,
	        HttpServletRequest request, HttpServletResponse response
	        ) throws Exception {
	    InputStream jasperStream = getClass().getResourceAsStream("/reports/purchs/purchaseForm.jasper");
	    
	    Map<String, Object> params = new HashMap<>();
	    params.put("p_companynum", companynum);
	    params.put("p_purchasenum", purchasenum);
	    
	    Connection conn = datasource.getConnection();
	    JasperPrint jasperPrint = JasperFillManager.fillReport(jasperStream, params, conn);
	    conn.close();

	    response.setContentType(MediaType.APPLICATION_PDF_VALUE);
	    JasperExportManager.exportReportToPdfStream(jasperPrint, response.getOutputStream());
	}
	
	@GetMapping("/reportDownload")
	public void reportDownload(
	        @RequestParam("companynum") int companynum, 
	        @RequestParam("purchasenum") long purchasenum,
	        HttpServletRequest request, HttpServletResponse response
	        ) throws Exception {
	    InputStream jasperStream = getClass().getResourceAsStream("/reports/purchs/purchaseForm.jasper");
	    
	    Map<String, Object> params = new HashMap<>();
	    params.put("p_companynum", companynum);
	    params.put("p_purchasenum", purchasenum);
	    
	    Connection conn = datasource.getConnection();
	    JasperPrint jasperPrint = JasperFillManager.fillReport(jasperStream, params, conn);
	    conn.close();
	    
	    response.setContentType(MediaType.APPLICATION_PDF_VALUE);
	    // 다운로드를 위한 헤더 설정: attachment; filename="파일명.pdf"
	    response.setHeader("Content-Disposition", "attachment; filename=\"purchaseOrder_" + purchasenum + ".pdf\"");
	    JasperExportManager.exportReportToPdfStream(jasperPrint, response.getOutputStream());
	}





}
