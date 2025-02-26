package com.beauty1nside;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
  
  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry.addResourceHandler("/file/image/stdr/document/**")
      .addResourceLocations("file:src/main/resources/static/file/image/stdr/document/") // 업로드 경로 설정
      .setCacheControl(CacheControl.noCache()); // 캐시 없이 즉시 반영
    
    registry.addResourceHandler("/file/image/mypage/profile/**")
      .addResourceLocations("file:src/main/resources/static/file/image/mypage/profile/")
      .setCacheControl(CacheControl.noCache());
  }
}