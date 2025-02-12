package com.beauty1nside.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
  
  @Bean
  PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }
  
  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http
      .authorizeHttpRequests((requests) -> requests
        .requestMatchers("/", "/").permitAll()
        // 원래 ROLE_ADMIN 인데 'ROLE_' 생략가능
        .requestMatchers("/admin").hasRole("ADMIN")
        //       그 외 모든 요청(HTTP 요청)에 대해 인증 요구
        .anyRequest().authenticated()
      )
      .formLogin((form) -> form
        .loginPage("/login")
        // form 의 username이 'userid'로 넘어오고 있음
        .usernameParameter("userid")
        .successHandler(authenticationSuccessHandler())
        .permitAll()
      )
      .logout((logout) -> logout.permitAll());
    // 활성화가 디폴트임
    // from tag 안에 인풋 히든으로 해서 name="_csrf" value="암호화된 토큰값"이 넘어감
    // 타임리프에서 넣어줌(<form th:action="@{/login}" 타임리프 문법 th 사용해야함)
    // ajax 방식은 이렇게 안하고 직접 넣어줘야함
//      .csrf(csrf -> csrf.disable());
    
    // 페이지로 이동도 가능하고 핸들러를 설정할 수도 있음
//    http.exceptionHandling(ex -> ex.accessDeniedPage("/error403.html"));
    http.exceptionHandling(ex -> ex.accessDeniedHandler(accessDeniedHandler()));
    
    return http.build();
  }
  
  @Bean
  public AccessDeniedHandler accessDeniedHandler() {
    return new CustomAccessDeniedHandler();
  }
  
//  @Bean
//  public UserDetailsService userDetailsService() {
//    UserDetails user =
//      User.withDefaultPasswordEncoder()
//        .username("user")
//        .password("1111")
//        .roles("USER")
//        .build();
//
//    UserDetails admin =
//      User.withDefaultPasswordEncoder()
//        .username("admin")
//        .password("1111")
//        .roles("ADMIN")
//        .build();
//
//    return new InMemoryUserDetailsManager(user, admin);
//  }
//
  @Bean
  public AuthenticationSuccessHandler authenticationSuccessHandler() {
    return new CustomLoginSuccessHandler();
  }
}