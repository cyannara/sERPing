package com.beauty1nside.bhf.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beauty1nside.bhf.mapper.DeptNameSearchMapper;

@Service
public class DeptNameSearchServiceImpl {

	@Autowired
	DeptNameSearchMapper mapper;
	
	public String getDeptName(int departmentNum ) {
		
		return mapper.getDeptName(departmentNum);
	}
	
}
