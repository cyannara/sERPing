package com.beauty1nside.hr.service.Impl;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.beauty1nside.hr.dto.OpenBankingTokenResponseDTO;
import com.beauty1nside.hr.service.OpenBankingService;

@Service
public class OpenBankingServiceImpl implements OpenBankingService {


    private static final String TOKEN_URL = "https://testapi.openbanking.or.kr/oauth/2.0/token";
    private static final String CLIENT_ID = "0635f11d-860f-41d0-8e9b-1081f24676c7"; // ⚠️ 반드시 API Key 관리에서 확인한 값으로 수정
    private static final String CLIENT_SECRET = "4311d60a-2621-4209-bbe3-94e405e0f35e"; // ⚠️ 반드시 올바른 값으로 수정

    @Override
    public OpenBankingTokenResponseDTO getAccessToken() {
        // ✅ 1. HTTP 요청 헤더 설정
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        // ✅ 2. 요청 바디 설정 (x-www-form-urlencoded 방식)
        MultiValueMap<String, String> requestBody = new LinkedMultiValueMap<>();
        requestBody.add("grant_type", "client_credentials");
        requestBody.add("client_id", CLIENT_ID);
        requestBody.add("client_secret", CLIENT_SECRET);
        requestBody.add("scope", "oob");

        // ✅ 3. HTTP 요청 객체 생성
        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(requestBody, headers);
        RestTemplate restTemplate = new RestTemplate();

        // ✅ 4. API 호출 (POST 요청)
        ResponseEntity<OpenBankingTokenResponseDTO> response = restTemplate.exchange(
                TOKEN_URL, HttpMethod.POST, requestEntity, OpenBankingTokenResponseDTO.class
        );

        // ✅ 5. 응답 출력 (디버깅)
        System.out.println("응답 코드: " + response.getStatusCode());
        System.out.println("응답 바디: " + response.getBody());

        // ✅ 6. 응답 반환
        if (response.getStatusCode() == HttpStatus.OK) {
            return response.getBody();
        } else {
            throw new RuntimeException("Access Token 발급 실패: " + response);
        }
    }
}