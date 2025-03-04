package com.beauty1nside.erp.dto;

import java.sql.Date;
import java.time.LocalDate;

import lombok.Data;

/**
 * ERP 관련 페이지 네이션 검색 항목들 저장 DTO
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
 *  2025.03.02  표하연          검색조건 개발에따른 변수 추가
 *
 *  </pre>
*/
@Data
public class ErpSearchListDTO {

	String companyName;
	int companyNum;
	boolean okContact;	// 계약
	boolean noContact;	// 미계약
	boolean useing;	// 사용중
	boolean unuseing;	// 만료
	boolean daysubscript;	// 기간구독
	boolean regulsubscript;	// 정기구독
	boolean lastday;	// 10일미만
	String okcunt;	//답변완료한 문의보기 ok 또는 null
	
	//10 일미만 날짜 속아 내기
	Date startday;
	Date endday;
	public void setLastday(boolean lastday) {
        this.lastday = lastday;
        if (lastday) {
            updateLastdayDates();
        }
    }
	// 날짜를 "yyyy-MM-dd" 형식의 문자열로 변환하여 반환하는 메서드
	public String getFormattedStartday() {
        return startday != null ? startday.toString() : null;
    }
    public String getFormattedEndday() {
        return endday != null ? endday.toString() : null;
    }
    public void updateLastdayDates() {
        if (lastday) {
            this.startday = Date.valueOf(LocalDate.now()); // 오늘 날짜
            this.endday = Date.valueOf(LocalDate.now().plusDays(10)); // 10일 이후 날짜
        }
    }
    
	//계약 관련 참거짓 통합
	String contact;
	public String getContact() {
        if (okContact && noContact) return "3";  // 둘 다 체크됨
        if (okContact) return "1";               // 계약만 체크됨
        if (noContact) return "2";               // 미계약만 체크됨
        return "0";                              // 둘 다 체크 안 됨
    }
	
	//서비스 관련 참거짓 통합
	String service;
	public String getService() {
		if(useing && unuseing) return "3";
		if(useing) return "1";
		if(unuseing) return "2";
		return "0";
	}
	
	//구독 형태
	String subform;
	public String getSubform() {
		if(daysubscript && regulsubscript) return "3";
		if(daysubscript) return "1";
		if(regulsubscript) return "2";
		return "0";
	}
	
}