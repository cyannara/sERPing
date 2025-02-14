package com.beauty1nside.accnut.mapper;

import java.util.List;

import com.beauty1nside.accnut.dto.SalaryBookDTO;
import com.beauty1nside.accnut.dto.SalaryBookSearchDTO;

public interface SalaryBookMapper {
	SalaryBookDTO info(String salaryAccountBookCode);
	List<SalaryBookDTO> list(SalaryBookSearchDTO dto);
	int count(SalaryBookSearchDTO dto);
}
