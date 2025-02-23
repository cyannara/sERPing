package com.beauty1nside.bsn;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.beauty1nside.bsn.dto.OrderSearchDTO;
import com.beauty1nside.bsn.dto.order.BhfOrderDTO;
import com.beauty1nside.bsn.dto.order.BhfOrderDetailDTO;
import com.beauty1nside.bsn.dto.order.BsnOrderDTO;
import com.beauty1nside.bsn.dto.order.BsnOrderDetailDTO;
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
		
//		List<BhfOrderDetailDTO> list = mapper.selectBhfOrderDetail(null)
	}
	
	
	
	//주문 등록 테스트
	//@Test
    @Transactional
    @Rollback(value = false) // 테스트 후 DB에 남기려면 false, 롤백하려면 true
    void testInsertBsnOrder() {
        // 1. 주문 상세 정보 생성
        BsnOrderDetailDTO detail1 = BsnOrderDetailDTO.builder()
            .goodsCode("G001")
            .optionCode("OPT01")
            .quantity(10)
            .goodsStandard("BOX")
            .unitPrice(500.0)
            .summationAmt(5000.0)
            .build();

        BsnOrderDetailDTO detail2 = BsnOrderDetailDTO.builder()
            .goodsCode("G002")
            .optionCode("OPT02")
            .quantity(5)
            .goodsStandard("EA")
            .unitPrice(1000.0)
            .summationAmt(5000.0)
            .build();

        List<BsnOrderDetailDTO> orderDetails = Arrays.asList(detail1, detail2);

        // 2. 주문 정보 생성
        BsnOrderDTO orderDTO = BsnOrderDTO.builder()
            .orderCode("ORD20240218")  // 발주 코드
            .branchOfficeId("BR001")   // 지점 ID
            .orderName("테스트 발주")
            .total_amount(10000L)
            .purchaseVat(1000L)
            .orderDate(new Date())
            .dueDate(new Date())
            .employeeNum(1234)  // 사번
            .companyNum(5678)   // 회사 번호
            .orderDetails(orderDetails) // 상세 리스트 추가
            .build();

        // 3. 주문 등록 프로시저 실행
        assertDoesNotThrow(() -> mapper.insertBsnOrder(orderDTO));

        System.out.println("✅ 주문 등록 테스트 완료");
    }

}
