package com.beauty1nside.erp;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.beauty1nside.erp.dto.testDTO;
import com.beauty1nside.erp.mapper.ErpAdminMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class MapperTest {
	
	@Autowired ErpAdminMapper erpAdminMapper;
	
	
	@Test
	@DisplayName("전체조회")
	public void testDate() {
		//given
		//when
		List<testDTO> list = erpAdminMapper.test();
		//then
		list.forEach(ele -> log.info(ele.toString()));
		//assertThat(list).isNotNull();
	}
}
