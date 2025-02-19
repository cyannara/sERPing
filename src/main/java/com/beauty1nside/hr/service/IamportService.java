package com.beauty1nside.hr.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.HashMap;
import java.util.Map;

@Service
public class IamportService {

    @Value("${iamport.api-key}")
    private String apiKey;

    @Value("${iamport.api-secret}")
    private String apiSecret;

    @Value("${iamport.token-url}")
    private String iamportTokenUrl;

    @Value("${iamport.account-holder-url}")
    private String iamportAccountHolderUrl;

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    public IamportService() {
        this.restTemplate = new RestTemplate();
        this.objectMapper = new ObjectMapper();
    }

    /**
     * ✅ 1. 포트원 Access Token 발급
     */
    public String getAccessToken() {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            Map<String, String> requestBody = new HashMap<>();
            requestBody.put("imp_key", apiKey);
            requestBody.put("imp_secret", apiSecret);

            HttpEntity<Map<String, String>> request = new HttpEntity<>(requestBody, headers);
            ResponseEntity<String> response = restTemplate.postForEntity(iamportTokenUrl, request, String.class);

            if (response.getStatusCode().is2xxSuccessful()) {
                JsonNode jsonResponse = objectMapper.readTree(response.getBody());
                return jsonResponse.path("response").path("access_token").asText();
            }

            throw new RuntimeException("Access Token 발급 실패: 응답 코드 " + response.getStatusCode());
        } catch (Exception e) {
            throw new RuntimeException("Access Token 요청 중 오류 발생", e);
        }
    }

    /**
     * ✅ 2. 예금주 조회
     */
    public String getAccountHolder(String bankCode, String accountNumber) {
        try {
            String accessToken = getAccessToken(); // 먼저 Access Token 발급

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.set("Authorization", "Bearer " + accessToken);

            String url = iamportAccountHolderUrl + "?bank_code=" + bankCode + "&bank_num=" + accountNumber;

            HttpEntity<Void> request = new HttpEntity<>(headers);
            ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, request, String.class);

            if (response.getStatusCode().is2xxSuccessful()) {
                JsonNode jsonResponse = objectMapper.readTree(response.getBody());
                return jsonResponse.path("response").path("bank_holder").asText();
            }

            return "예금주 조회 실패";
        } catch (Exception e) {
            return "예금주 조회 중 오류 발생: " + e.getMessage();
        }
    }
}
