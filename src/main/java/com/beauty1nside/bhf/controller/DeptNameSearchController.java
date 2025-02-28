package com.beauty1nside.bhf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.beauty1nside.bhf.service.impl.DeptNameSearchServiceImpl;

@RestController
@RequestMapping("/deptName")
public class DeptNameSearchController {

	@Autowired
	DeptNameSearchServiceImpl service;
	
	@GetMapping("/{departmentNum}")
	public String getDeptName(@PathVariable int departmentNum) {
		
		return service.getDeptName(departmentNum);
	}
	
}
