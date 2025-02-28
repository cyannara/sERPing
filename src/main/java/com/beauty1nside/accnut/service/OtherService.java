package com.beauty1nside.accnut.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface OtherService {
	List<Map<String, Object>> optionList(String goodsName, int companyNum);
	List<Map<String, Object>> bhfList(int companyNum);
	Map<String, Object> companyInfo(int companyNum);
}
