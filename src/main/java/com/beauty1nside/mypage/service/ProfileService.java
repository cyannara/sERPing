package com.beauty1nside.mypage.service;

import com.beauty1nside.hr.dto.EmpDTO;

public interface ProfileService {
  EmpDTO info(EmpDTO dto);
  int update(EmpDTO dto);
  
}
