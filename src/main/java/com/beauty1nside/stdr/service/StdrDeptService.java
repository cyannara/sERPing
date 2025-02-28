package com.beauty1nside.stdr.service;

import com.beauty1nside.hr.dto.DeptDTO;

import java.util.List;

public interface StdrDeptService {
  List<DeptDTO> hqDeptList(Long companyNum);
}
