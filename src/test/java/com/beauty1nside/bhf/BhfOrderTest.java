package com.beauty1nside.bhf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.beauty1nside.bhf.dto.goodsin.BhfGoodsInVO;
import com.beauty1nside.bhf.mapper.BhfGoodsInMapper;

@SpringBootTest
public class BhfOrderTest {

//	@Autowired 
//	BhfOrderMapper mapper;
//	
//	//@Test
//	public void testStruct() {
//		BhfOrdVO vo = new BhfOrdVO();
//		vo.setBranchOfficeId("Yedam");
//		vo.setDueDate(new Date(2025-02-14));
//		vo.setRemark("");
//		vo.setCompanyNum(14);
//		vo.setFiles(List.of(new BhfOrdDtlVO("g1","skin","o1","100ml","1b/6p",5),
//				            new BhfOrdDtlVO("g1","skin","o2","500ml","1b/6p",3),
//				            new BhfOrdDtlVO("g1","lotion","o1","50ml","1b/6p",10)
//				   ));
//		
//		mapper.orderPrd(vo);
//		
//		System.out.println("TEST실행성공");
//	}
//	
//	//@Test
//	public void goodsListTest() {
//		List<BhfGoodsOpDTO> list = mapper.goodsList(null);
//		System.out.println(list);
//	}
	
//	@Test
//	public void optionListTest() {
//		String goodsCode = "LH001";
//		List<BhfGoodsOpDTO> list = mapper.optionList(goodsCode);
//		System.out.println(list);
//	}
	
//	@Autowired
//	BhfReturnMapper mapper;
//	
//	//@Test
//	public void testingStruct() {
//		BhfReturningVO vo = new BhfReturningVO();
//		vo.setBranchOfficeId("Yedam");
//		vo.setRemark("");
//		vo.setCompanyNum(1);
//		vo.setFiles(List.of(new BhfReturningDtlVO("LH001","헤라글로우틴트", "LH0011","422호스피치리스",3,"교환","파손"),
//							new BhfReturningDtlVO("LH001","헤라글로우틴트", "LH0012","308호체리쉬",3,"교환","파손")
//					));
//		mapper.returnGoods(vo);
//		System.out.println("TEST succes");
//	}
	
	 @Autowired 
	    private BhfGoodsInMapper goodsInMapper; // 위에서 만든 MERGE 쿼리 실행하는 Mapper

	    @Test
	    void 상품입고_테스트() {
	        // given: 입고 데이터 생성
	    	List<BhfGoodsInVO> goodsList = new ArrayList<>(Arrays.asList(
	    		    new BhfGoodsInVO("B001", "G1001", "상품A", "O1001", "옵션1", "M", 10, 1),
	    		    new BhfGoodsInVO("yedam", "LH001", "헤라글로우틴트", "LH0012", "308호체리쉬", "L", 20, 1)
	    		));

	        // when: goodsIn() 실행 (MERGE INTO 실행)
	        int result = goodsInMapper.goodsIn(goodsList);

	        // then: 실행 결과 검증
	        Assertions.assertTrue(result > 0, "입고 처리 실패 (0행 적용)");

	        // 성공 메시지 출력
	        System.out.println("✅ 상품 입고 MERGE 테스트 성공! " + result + " rows affected.");
	    }
	    

	
}
