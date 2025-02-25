package com.beauty1nside.accnut.controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.beauty1nside.accnut.dto.AssetDTO;
import com.beauty1nside.accnut.dto.NHDTO;
import com.fasterxml.jackson.core.JsonProcessingException;

import lombok.Data;
import lombok.extern.log4j.Log4j2;

@Data
@Log4j2
public class NHService {
		
	// 공통 필드
	RestTemplate restTemplate = new RestTemplate();
	
	public String getDate() {
		LocalDate date = LocalDate.now();
		DateTimeFormatter dateForm = DateTimeFormatter.ofPattern("yyyyMMdd");
		String dateValue = date.format(dateForm);
		
		return dateValue;
	}
	
	public String getTime() {
		LocalTime time = LocalTime.now();
		DateTimeFormatter timeForm = DateTimeFormatter.ofPattern("HHmmss");
		String timeValue = time.format(timeForm);
		
		return timeValue;
	}
	
	
	public HttpHeaders getHeaders() {
		// HTTP 헤더 설정 (JSON 형식)
	    HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.APPLICATION_JSON);
	    
	    return headers;
	}
	
	// 핀어카운트 직접 발급	------------------------------------------------------------
	public String getRgno(AssetDTO dto) {
		
		String rgno = null;
		
		String url1 = "https://developers.nonghyup.com/OpenFinAccountDirect.nh";
		
		// 요청 파라미터 생성
        Map<String, Object> paramMap1 = new HashMap<>();
        Map<String, String> headerMap1 = new HashMap<>();
        headerMap1.put("ApiNm", "OpenFinAccountDirect");
        headerMap1.put("Tsymd", getDate());
        headerMap1.put("Trtm", getTime());
        headerMap1.put("Iscd", "002869");
        headerMap1.put("FintechApsno", "001");
        headerMap1.put("ApiSvcCd", "DrawingTransferA");
        headerMap1.put("IsTuno", String.valueOf(System.currentTimeMillis()) );
        headerMap1.put("AccessToken", "f992edaa21154e076a3f2d856c37d2aaf72a4f8f72d009c89ded50fa9b917098");
        paramMap1.put("Header", headerMap1);
        paramMap1.put("DrtrRgyn", "Y");
        paramMap1.put("BrdtBrno", "19970723");
        paramMap1.put("Bncd", "011");
        paramMap1.put("Acno", dto.getFinanceInformation());
        
        log.info(paramMap1);
        
        HttpEntity<Map<String, Object>> requestEntity1 = new HttpEntity<>(paramMap1, getHeaders());
        
        try {
            // POST 방식으로 API 호출 (응답 DTO는 API의 응답 구조에 맞게 정의)
            ResponseEntity<NHDTO> response1 = restTemplate.postForEntity(url1, requestEntity1, NHDTO.class );
            NHDTO responseBody1 = response1.getBody();
            
            if (responseBody1 != null) {
            	rgno = responseBody1.getRgno();
            }
            
        } catch (Exception e) {
            // 호출 실패 시 로그 남기기
            log.error("Nonghyup API 호출 실패: {}", e.getMessage());
        }
		
		return rgno;
	}
	
	// 핀어카운트 직접 발급 확인 ----------------------------------------------
	public String getFinAcno(AssetDTO dto) {
		
		String finAcno = null;
		String url2 = "https://developers.nonghyup.com/CheckOpenFinAccountDirect.nh";
		
		// 요청 파라미터 생성
        Map<String, Object> paramMap2 = new HashMap<>();
        Map<String, String> headerMap2 = new HashMap<>();
        headerMap2.put("ApiNm", "CheckOpenFinAccountDirect");
        headerMap2.put("Tsymd", getDate());
        headerMap2.put("Trtm", getTime());
        headerMap2.put("Iscd", "002869");
        headerMap2.put("FintechApsno", "001");
        headerMap2.put("ApiSvcCd", "DrawingTransferA");
        headerMap2.put("IsTuno", String.valueOf(System.currentTimeMillis()) );
        headerMap2.put("AccessToken", "f992edaa21154e076a3f2d856c37d2aaf72a4f8f72d009c89ded50fa9b917098");
        paramMap2.put("Header", headerMap2);
        paramMap2.put("Rgno", dto.getRgno());
        paramMap2.put("BrdtBrno", "19970723");
        log.info(paramMap2);
        
       
        HttpEntity<Map<String, Object>> requestEntity2 = new HttpEntity<>(paramMap2, getHeaders());
        
        try {
            // POST 방식으로 API 호출 (응답 DTO는 API의 응답 구조에 맞게 정의)
            ResponseEntity<NHDTO> response = restTemplate.postForEntity(url2, requestEntity2, NHDTO.class );
            NHDTO responseBody = response.getBody();
            log.info(responseBody);

            
            if (responseBody != null) {
            	finAcno = responseBody.getFinAcno();
            }
        } catch (Exception e) {
            // 호출 실패 시 로그 남기기
            log.error("Nonghyup API 호출 실패: {}", e.getMessage());
        }
		
		
		return finAcno;
	}
	
	// 잔액 조회 -------------------------------------------------------------------------
	public String getAmount(String finAcno) throws JsonProcessingException {
		
		String result = null;
		String url3 = "https://developers.nonghyup.com/InquireBalance.nh";
		
        // 요청 파라미터 생성
        Map<String, Object> paramMap = new HashMap<>();
        Map<String, String> headerMap = new HashMap<>();
        headerMap.put("ApiNm", "InquireBalance");
        headerMap.put("Tsymd", getDate());
        headerMap.put("Trtm", getTime());
        headerMap.put("Iscd", "002869");
        headerMap.put("FintechApsno", "001");
        headerMap.put("ApiSvcCd", "ReceivedTransferA");
        headerMap.put("IsTuno", String.valueOf(System.currentTimeMillis()) );
        headerMap.put("AccessToken", "f992edaa21154e076a3f2d856c37d2aaf72a4f8f72d009c89ded50fa9b917098");
        paramMap.put("Header", headerMap);
        paramMap.put("FinAcno", finAcno);
        
        log.info(paramMap);
        
        
     	// HttpEntity 생성 (헤더와 바디 포함)
        HttpEntity<Map<String, Object>> requestEntity = new HttpEntity<>(paramMap, getHeaders());
        
        try {
            // POST 방식으로 API 호출 (응답 DTO는 API의 응답 구조에 맞게 정의)
            ResponseEntity<NHDTO> response = restTemplate.postForEntity(url3, requestEntity, NHDTO.class );
            NHDTO responseBody = response.getBody();
            
            log.info(responseBody);
            
            if (responseBody != null) {
            	result = responseBody.getLdbl();
            	
            }
        } catch (Exception e) {
            // 호출 실패 시 로그 남기기
            log.error("Nonghyup API 호출 실패: {}", e.getMessage());
        }
		
		return result;
	}
	
	// 출금이체	------------------------------------------------------------
		public boolean withdraw(String finAcno, String total) {
			
			boolean bool = false;
			
			String url1 = "https://developers.nonghyup.com/DrawingTransfer.nh";
			
			// 요청 파라미터 생성
	        Map<String, Object> paramMap4 = new HashMap<>();
	        Map<String, String> headerMap4 = new HashMap<>();
	        headerMap4.put("ApiNm", "DrawingTransfer");
	        headerMap4.put("Tsymd", getDate());
	        headerMap4.put("Trtm", getTime());
	        headerMap4.put("Iscd", "002869");
	        headerMap4.put("FintechApsno", "001");
	        headerMap4.put("ApiSvcCd", "DrawingTransferA");
	        headerMap4.put("IsTuno", String.valueOf(System.currentTimeMillis()) );
	        headerMap4.put("AccessToken", "f992edaa21154e076a3f2d856c37d2aaf72a4f8f72d009c89ded50fa9b917098");
	        paramMap4.put("Header", headerMap4);
	        paramMap4.put("FinAcno", finAcno);
	        paramMap4.put("Tram", total);
	        
	        log.info(paramMap4);
	        
	        HttpEntity<Map<String, Object>> requestEntity4 = new HttpEntity<>(paramMap4, getHeaders());
	        
	        try {
	            // POST 방식으로 API 호출 (응답 DTO는 API의 응답 구조에 맞게 정의)
	            ResponseEntity<NHDTO> response4 = restTemplate.postForEntity(url1, requestEntity4, NHDTO.class );
	            NHDTO responseBody4 = response4.getBody();
	            
	            if (responseBody4 != null) {
	            	bool = finAcno.equals( responseBody4.getFinAcno() );
	            }
	            
	        } catch (Exception e) {
	            // 호출 실패 시 로그 남기기
	            log.error("Nonghyup API 호출 실패: {}", e.getMessage());
	        }
			
			return bool;
		}
	
	
    
}
