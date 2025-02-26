package com.beauty1nside.purchs.mapper;

import java.util.List;

import com.beauty1nside.purchs.dto.PurchInsertVO;
import com.beauty1nside.purchs.dto.PurchaseDTO;
import com.beauty1nside.purchs.dto.PurchaseSearchDTO;

public interface purchaseMapper {
	//발주서 등록 (거래처 id 별로 등록)
	public void purchaseInsert(PurchInsertVO vo);
	
	//발주서 조회 
	List<PurchaseDTO>purchaseList(PurchaseSearchDTO dto);
	int purchaseCount(PurchaseSearchDTO dto);
	
	
	//미입고발주서조회 
	List<PurchaseDTO>nonwarehousinglist(PurchaseSearchDTO dto);
	int nonwarehousingCount(PurchaseSearchDTO dto);
}
