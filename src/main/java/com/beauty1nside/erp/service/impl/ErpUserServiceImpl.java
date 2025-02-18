package com.beauty1nside.erp.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.beauty1nside.erp.dto.ErpSubOptionDTO;
import com.beauty1nside.erp.dto.erpSubscriptionInfoListDTO;
import com.beauty1nside.erp.mapper.ErpUserMapper;
import com.beauty1nside.erp.service.ErpUserService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

/**
 * ERP 사용 회사 CRUD 하는 서비스 클래스
 * @author ERP 관리자 개발팀 표하연
 * @since 2025.02.17
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 *   수정일      수정자          수정내용
 *  -------    --------    ---------------------------
 *  2025.02.17  표하연          최초 생성
 *
 *  </pre>
*/
@Log4j2
@Service	//★이거 무조건 넣어!!
//@AllArgsConstructor	//모든필드를 생성자 초기화 한다
@RequiredArgsConstructor //파이널 붙어 있는 필드만 초기화 해준다
//필드 하나뿐이면 그냥 all 하고 여러개이면 Required
public class ErpUserServiceImpl implements ErpUserService {

	/**
     * ErpUserMapper 맵퍼를 사용하기 위한 의존성 주입
     */
	private final ErpUserMapper erpUserMapper;
	
	/**
     * 고객 구독 정보를 받아옴
     *
     * @param int
     * @return List<erpSubscriptionInfoListDTO>
     */
	@Override
	public List<erpSubscriptionInfoListDTO> sublist(int comapnyNum) {
		return erpUserMapper.sublist(comapnyNum);
	}

	/**
     * 회사 인사인원 확인
     *
     * @param int
     * @return int
     */
	@Override
	public int hrlist(int companyNum) {
		return erpUserMapper.hrlist(companyNum);
	}

	/**
     * 기간 구독 서비스를 등록한다
     *
     * @param Map<String, Object>
     * @return int
     */
	@Override
	@Transactional
	public int periodservicepay(Map<String, Object> requestData) {
		
		log.info("결제정보 : "+requestData);
		
	    int companyNum = (int) requestData.get("companyNum");
		
		//결제 헤더 등록하기 erp_subscription_list [1개]
		String price = requestData.get("price").toString().replace(",", "");
		requestData.put("price", price);
	
		//결제 바디 등록하기 erp_subscription_tail [여러개]
		erpUserMapper.prosubscriptionlist(requestData);
		
		int lastKey = erpUserMapper.lastpaykey(requestData);
		log.info("마지막기본키 : "+lastKey);
		
		//결제 정보로 구독목록 업뎃하기 erp_subscription_info_list [여러개] 바디 포문안에서 해야함
		String[] optionNum = ((String) requestData.get("orderId")).split("_");
		for (String ele : optionNum) {
		    //ele => 옵션번호 // 이거랑 lastKey 이용해서 인서트
		    //구독 결제 디테일 저장
		    erpUserMapper.prosubscriptiontail(lastKey, Integer.parseInt(ele));
		    
		    ErpSubOptionDTO dto = erpUserMapper.lastoptionlist(Integer.parseInt(ele));
		    log.info("dto정보 : "+dto);
		    log.info("dto정보 : "+dto.getSubscriptionNameNum());
		    // 옵션번호로 구독정보 조회해서 서 해당 구독정보에 맞는 구독 상품 업데이트 하기
		    erpSubscriptionInfoListDTO subDTO = new erpSubscriptionInfoListDTO();
		    if(dto.getSubscriptionNameNum() == 1 || dto.getSubscriptionNameNum() == 6) {
		    	subDTO = erpUserMapper.subinfo(companyNum, 1, 6);
		    }else if(dto.getSubscriptionNameNum() == 2 || dto.getSubscriptionNameNum() == 7) {
		    	subDTO = erpUserMapper.subinfo(companyNum, 2, 7);
		    }else if(dto.getSubscriptionNameNum() == 3 || dto.getSubscriptionNameNum() == 8) {
		    	subDTO = erpUserMapper.subinfo(companyNum, 3, 8);
		    }else if(dto.getSubscriptionNameNum() == 4 || dto.getSubscriptionNameNum() == 9) {
		    	subDTO = erpUserMapper.subinfo(companyNum, 4, 9);
		    }else if(dto.getSubscriptionNameNum() == 5 || dto.getSubscriptionNameNum() == 10) {
		    	subDTO = erpUserMapper.subinfo(companyNum, 5, 10);
		    }
		    log.info("현재 구독 정보 리스트 : "+subDTO);
		    //null이면 생성시켜주고 [ dto.getSubscriptionNameNum() ] 값에 맞는걸로 인서트
		    
		    //값이 있으면 기본키로 업데이트 시키고
		    //내용은 만료일 가져와서 계산해서 만료일 증가시키고, 
		    //정기결제인경우 만료일이 지났으면 기간결제로 바꾸고 만료일 증가시키기
		}
		
		log.info("결제정보 : "+requestData);

		return 1;
	}

}
