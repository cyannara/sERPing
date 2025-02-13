package com.beauty1nside.bsn;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.beauty1nside.bsn.dto.BhfOrderDTO;
import com.beauty1nside.bsn.dto.OrderSearchDTO;
import com.beauty1nside.bsn.mapper.BsnOrderMapper;
import com.beauty1nside.bsn.service.BsnOrderService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class BsnTest {
	
	@Autowired BsnOrderService service;
	@Autowired BsnOrderMapper mapper;
	
//	@Test
	@DisplayName("발주신청조회")
	public void test1() {
		
		
//		List<BhfOrderDTO> list = service.getBhfOrder();
//		List<BhfOrderDTO> list = mapper.selectBhfOrder();
//		list.forEach(ele -> log.info(ele.toString()));
	}

}
