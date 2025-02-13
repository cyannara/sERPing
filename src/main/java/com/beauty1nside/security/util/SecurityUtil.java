package com.beauty1nside.security.util;

import com.beauty1nside.security.service.CustomerUser;
import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityUtil {
  private SecurityUtil() {
    // 인스턴스 생성 방지 (유틸리티 클래스)
  }
  
  public static CustomerUser getCustomerUser() {
    Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    
    if (principal instanceof CustomerUser) {
      return (CustomerUser) principal;
    } else {
      throw new IllegalStateException("현재 인증된 사용자가 CustomerUser 타입이 아닙니다.");
    }
  }
}
