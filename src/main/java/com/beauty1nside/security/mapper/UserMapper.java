package com.beauty1nside.security.mapper;

import com.beauty1nside.security.service.UserDTO;

public interface UserMapper {
  UserDTO getUser(String employeeId);
}
