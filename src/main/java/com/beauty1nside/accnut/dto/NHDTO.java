package com.beauty1nside.accnut.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class NHDTO {
	
	@JsonProperty("Rgno")
	private String Rgno;

	@JsonProperty("FinAcno")
	private String FinAcno;
	
	@JsonProperty("Header")
    private Header Header; // JSON의 Header 객체
	
	@JsonProperty("Ldbl")
    private String Ldbl;
	
	@JsonProperty("RlpmAbamt")
    private String RlpmAbamt;

    // 내부 클래스 Header
    @Data
    public static class Header {
    	
    	@JsonProperty("Trtm")
        private String Trtm;
    	
    	@JsonProperty("Rsms")
        private String Rsms;
    	
    	@JsonProperty("ApiNm")
        private String ApiNm;
    	
    	@JsonProperty("IsTuno")
        private String IsTuno;
    	
    	@JsonProperty("Tsymd")
        private String Tsymd;
    	
    	@JsonProperty("FintechApsno")
        private String FintechApsno;
    	
    	@JsonProperty("Iscd")
        private String Iscd;
    	
    	@JsonProperty("Rpcd")
        private String Rpcd;
    	
    	@JsonProperty("ApiSvcCd")
        private String ApiSvcCd;
    	
    }
	
}
