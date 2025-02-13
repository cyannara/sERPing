package com.beauty1nside.erp.controller;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.log4j.Log4j2;

/**
 * 배포전에 답답해서 개인서버에 파일 저장을 하게 한다
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
@Log4j2
@RestController	//★★★
@RequestMapping("/erp/rest/*")
public class FTPFileUploadController {

	private final String ftpHost;
    private final int ftpPort;
    private final String ftpUser;
    private final String ftpPass;
    private final String ftpUploadDir;

    public FTPFileUploadController(
            @Value("${ftp.host}") String ftpHost,
            @Value("${ftp.port}") int ftpPort,
            @Value("${ftp.user}") String ftpUser,
            @Value("${ftp.pass}") String ftpPass,
            @Value("${ftp.upload.dir}") String ftpUploadDir) {
        this.ftpHost = ftpHost;
        this.ftpPort = ftpPort;
        this.ftpUser = ftpUser;
        this.ftpPass = ftpPass;
        this.ftpUploadDir = ftpUploadDir;
    }

    /**
     * DB연결 확인을 위하여 샘플 데이터를 조회
     *
     * @param MultipartFile
     * @return String
     */
    @PostMapping("/uploadBusinessLicense")
    public String uploadFileToFTP(@RequestParam("file") MultipartFile file) {
        FTPClient ftpClient = new FTPClient();

        try {
            // 1. FTP 서버 연결
            ftpClient.connect(ftpHost, ftpPort);
            ftpClient.login(ftpUser, ftpPass);
            ftpClient.enterLocalPassiveMode();
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);

            // 2. 파일명 뒤에 현재 시간 추가 (yyyyMMdd_HHmmss)
            String originalFileName = file.getOriginalFilename();
            if (originalFileName == null || originalFileName.isEmpty()) {
                return "FAIL"; // 파일명이 없을 경우 실패 처리
            }

            // 파일 확장자 분리
            String extension = "";
            int dotIndex = originalFileName.lastIndexOf(".");
            if (dotIndex != -1) {
                extension = originalFileName.substring(dotIndex); // 확장자 포함
                originalFileName = originalFileName.substring(0, dotIndex); // 확장자 제외한 파일명
            }

            // 현재 날짜 및 시간 추가
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String newFileName = originalFileName + "_" + timestamp + extension;

            // 3. 파일 업로드
            String remoteFilePath = ftpUploadDir + newFileName;
            try (InputStream inputStream = file.getInputStream()) {
                boolean uploaded = ftpClient.storeFile(remoteFilePath, inputStream);
                return uploaded ? newFileName : "FAIL";
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "FAIL";
        } finally {
            try {
                if (ftpClient.isConnected()) {
                    ftpClient.logout();
                    ftpClient.disconnect();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}