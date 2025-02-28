<?php
// Spring Boot API URL 설정
$api_url = "http://localhost:81/erp/rest/phpcontact";

// 입력 데이터 가져오기
$data = array(
    "companyName" => $_POST['companyName'] ?? '',
    "chargerEmail" => $_POST['chargerEmail'] ?? '',
    "chargerName" => $_POST['chargerName'] ?? '',
    "chargerPhone" => $_POST['chargerPhone'] ?? '',
    "inquiryContent" => $_POST['inquiryContent'] ?? ''
);

// JSON 형식으로 변환
$json_data = json_encode($data);

// cURL 요청 설정
$ch = curl_init($api_url);
curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
curl_setopt($ch, CURLOPT_POST, true);
curl_setopt($ch, CURLOPT_POSTFIELDS, $json_data);
curl_setopt($ch, CURLOPT_HTTPHEADER, array(
    'Content-Type: application/json',
    'Accept: application/json'
));

// API 호출 및 응답 받기
$response = curl_exec($ch);
$http_status = curl_getinfo($ch, CURLINFO_HTTP_CODE);
curl_close($ch);

// 응답 확인 후 리다이렉트 없이 JSON 반환
if ($http_status == 200) {
    echo json_encode(["status" => "OK"]);
    exit;
} else {
    echo json_encode(["status" => "error", "message" => $response]);
    exit;
}