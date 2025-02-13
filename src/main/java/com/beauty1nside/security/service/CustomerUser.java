package com.beauty1nside.security.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
public class CustomerUser implements UserDetails {
  UserDTO userDTO;
  
  @Override
  public boolean isAccountNonExpired() {
    return true;
  }
  
  @Override
  public boolean isAccountNonLocked() {
    return true;
  }
  
  @Override
  public boolean isEnabled() {
    // 로그인 막으려면 false(ex. 휴먼계정이나..)
    return true;
  }
  
  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return userDTO
      .getRoles()
      .stream()
      .map(role -> new SimpleGrantedAuthority(role.getRoleName()))
      .collect(Collectors.toList());
  }
  
  @Override
  public String getPassword() {
    return userDTO.getEmployeePw();
  }
  
  @Override
  public String getUsername() {
    return userDTO.getEmployeeId();
  }
}
