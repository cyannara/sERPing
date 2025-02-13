package com.beauty1nside.security.service;

import com.beauty1nside.security.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
  private final UserMapper userMapper;
  
  @Override
  public UserDetails loadUserByUsername(String employeeId) throws UsernameNotFoundException {
    UserDTO userDTO = userMapper.getUser(employeeId);
    
    System.out.println("CustomUserDetailsService userDTO = " + userDTO);
    
    if(userDTO == null) {
      throw new UsernameNotFoundException("id check");
    }
    
    // 비밀번호가 null인지 체크 (로그 추가)
    if (userDTO.getEmployeePw() == null || userDTO.getEmployeePw().isEmpty()) {
      throw new UsernameNotFoundException("비밀번호가 없음: " + employeeId);
    }
    
    // 비밀번호 해싱 확인 로그
    System.out.println("DB에서 가져온 암호화된 비밀번호: " + userDTO.getEmployeePw());
    
    return new CustomerUser(userDTO);
  }
}
