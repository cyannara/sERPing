package com.beauty1nside.security.mapper;

import com.beauty1nside.security.service.RoleDTO;
import com.beauty1nside.security.service.UserDTO;

import java.util.List;

public interface UserMapper {
  UserDTO getUser(String loginId);
  List<RoleDTO> getRole(Long id);
}
