package com.beauty1nside.accnut.service;

import java.util.List;

import com.beauty1nside.accnut.dto.SalaryBookDTO;
import com.beauty1nside.accnut.dto.SalaryBookSearchDTO;

public interface SalaryBookService {
	SalaryBookDTO info(String salaryAccountBookCode);
	List<SalaryBookDTO> list(SalaryBookSearchDTO dto);
	int count(SalaryBookSearchDTO dto);
	int update(List<SalaryBookDTO> dtoList);
}
