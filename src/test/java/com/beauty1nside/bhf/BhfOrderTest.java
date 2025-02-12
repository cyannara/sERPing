package com.beauty1nside.bhf;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.beauty1nside.bhf.dto.BhfOrdDtlVO;
import com.beauty1nside.bhf.dto.BhfOrdVO;
import com.beauty1nside.bhf.mapper.BhfOrderMapper;

@SpringBootTest
public class BhfOrderTest {

	@Autowired 
	BhfOrderMapper Mapper;
	
	@Test
	public void testStruct() {
		BhfOrdVO vo = new BhfOrdVO();
		vo.setBranchOfficeId("Yedam");
		vo.setDueDate(new Date(2025-02-14));
		vo.setRemark("");
		vo.setCompanyNum(14);
		vo.setFiles(List.of(new BhfOrdDtlVO("g1","skin","o1","100ml","1b/6p",5),
				            new BhfOrdDtlVO("g1","skin","o2","500ml","1b/6p",3),
				            new BhfOrdDtlVO("g1","lotion","o1","50ml","1b/6p",10)
				   ));
		
		Mapper.orderPrd(vo);
		System.out.println("TEST실행");
	}
	
}
