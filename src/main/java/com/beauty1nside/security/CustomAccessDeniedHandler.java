package com.beauty1nside.security;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import java.io.IOException;

public class CustomAccessDeniedHandler implements AccessDeniedHandler {
  private Logger log = LoggerFactory.getLogger(CustomAccessDeniedHandler.class);
  
  @Override
  public void handle(HttpServletRequest request,
                     HttpServletResponse response,
                     AccessDeniedException accessDeniedException) throws IOException {
    log.info("No Authorities: {}", accessDeniedException);
    log.info("Request Uri: {}", request.getRequestURI());
    
    response.setContentType(MediaType.APPLICATION_JSON_VALUE);
    response.setStatus(HttpStatus.FORBIDDEN.value());
    response.setCharacterEncoding("UTF-8");
    response.getWriter().write("permission error");
  }
}