package com.beauty1nside.stdr.service;

import com.beauty1nside.stdr.dto.StdrDeptDTO;

import java.util.List;

public interface StdrDeptService {
  List<StdrDeptDTO> hqDeptList(Long companyNum);
  List<StdrDeptDTO> deptList(Long companyNum);
}
