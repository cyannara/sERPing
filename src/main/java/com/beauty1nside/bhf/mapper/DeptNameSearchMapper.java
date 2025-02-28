package com.beauty1nside.bhf.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DeptNameSearchMapper {

	String getDeptName(int departmentNum);
	
}
