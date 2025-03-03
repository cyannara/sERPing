package com.beauty1nside.purchs.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.beauty1nside.purchs.dto.ProductDTO;
import com.beauty1nside.purchs.dto.ProductSearchDTO;
import com.beauty1nside.purchs.dto.ProdInsertVO;
import com.beauty1nside.purchs.dto.ProdUpdateVO;

public interface productMapper {
	//카테고리 조회 (드롭박스)
	List<ProductDTO> getCatelist(@Param("companyNum") int companyNum);
	
	//브랜드 조회 (모달)
	List<ProductDTO>brandlist(ProductSearchDTO dto);
	int brandcount(ProductSearchDTO dto);
	
	//거래처 조회 (모달)
	List<ProductDTO>vendorlist(ProductSearchDTO dto);
	int vendorcount(ProductSearchDTO dto);
	
	//창고조회 (모달)
	List<ProductDTO>warehouselist(ProductSearchDTO dto);
	int warehousecount(ProductSearchDTO dto);
	
	//상품,옵션 등록 
	public void goodsinsert(ProdInsertVO vo);
	
	//상품리스트 조회
	List<ProductDTO>goodslist(ProductSearchDTO dto);
	int productcount(ProductSearchDTO dto);
	
	//상품 상세 정보 조회 
	List<ProductDTO>goodsoptioninfo(@Param("goodsCode") String goodsCode, 
            						@Param("companyNum") int companyNum);
	
	//상품, 옵션 수정 
	public void goodsupdate (ProdUpdateVO vo);
	
	//상품별재고갯수 조회
	List<ProductDTO>goodsNum(ProductSearchDTO dto);
	int goodsNumcount(ProductSearchDTO dto);
	
	//상품 lot 갯수 조회
	List<ProductDTO>goodsLotNum(ProductSearchDTO dto);
	int goodsLotNumcount(ProductSearchDTO dto);
}
