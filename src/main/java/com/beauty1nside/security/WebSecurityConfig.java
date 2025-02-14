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
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http
      .authorizeHttpRequests(authorize -> authorize
        .anyRequest().permitAll() // 모든 요청을 인증 없이 허용
      )
      .csrf(csrf -> csrf.disable()) // CSRF 비활성화
      .formLogin(form -> form.disable()) // 로그인 폼 비활성화
      .logout(logout -> logout.disable()); // 로그아웃 비활성화

    return http.build();
  }
  
  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }
  
//  @Bean
//  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//    http
//      .authorizeHttpRequests((requests) -> requests
//        .requestMatchers("/", "/common/**", "/css/**", "/docs/**", "/file/**", "/fonts/**", "/images/**", "/js/**", "/scss/**", "/templates/**", "/vendors/**", "/gulpfile.js").permitAll()
//        // 원래 ROLE_ADMIN 인데 'ROLE_' 생략가능
////        .requestMatchers("/admin").hasRole("ADMIN")
//        //       그 외 모든 요청(HTTP 요청)에 대해 인증 요구
//        .anyRequest().authenticated()
//      )
//      .formLogin((form) -> form
//        .loginPage("/login")
//        .usernameParameter("employeeId")
//        .passwordParameter("employeePw")
////        .defaultSuccessUrl("/", true) // ✅ 로그인 성공 후 항상 "/"로 이동
//        .successHandler(authenticationSuccessHandler())
//        .permitAll()
//      )
//      .logout((logout) -> logout.permitAll())
//      .csrf(csrf -> csrf.disable())	// 기본적으로 사용으로 되어있음 이거 없애면 사용임
//		.cors(cors -> cors
//             .configurationSource(CorsConfig.corsConfigurationSource())
//      );
//    // 활성화가 디폴트임
//    // from tag 안에 인풋 히든으로 해서 name="_csrf" value="암호화된 토큰값"이 넘어감
//    // 타임리프에서 넣어줌(<form th:action="@{/login}" 타임리프 문법 th 사용해야함)
//    // ajax 방식은 이렇게 안하고 직접 넣어줘야함
////      .csrf(csrf -> csrf.disable());
//
//    // 페이지로 이동도 가능하고 핸들러를 설정할 수도 있음
////    http.exceptionHandling(ex -> ex.accessDeniedPage("/error403.html"));
//    http.exceptionHandling(ex -> ex.accessDeniedHandler(accessDeniedHandler()));
//
//    return http.build();
//  }
  
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

  @Bean
  public AuthenticationSuccessHandler authenticationSuccessHandler() {
    return new CustomLoginSuccessHandler();
  }
}