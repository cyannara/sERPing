package com.beauty1nside.purchs.service;

import java.util.List;

import com.beauty1nside.purchs.dto.ProductDTO;
import com.beauty1nside.purchs.dto.ProductSearchDTO;
import com.beauty1nside.purchs.dto.ProdInsertVO;
import com.beauty1nside.purchs.dto.ProdUpdateVO;

public interface productService {
	//카테고리 조회 
	List<ProductDTO> getCatelist(int companyNum);  // ✅ companyNum 추가
	
	//브랜드 조회
	public List<ProductDTO> getBrandlist(ProductSearchDTO dto);
	int brandcount(ProductSearchDTO dto);
	
	//거래처 조회 
	public List<ProductDTO> getVendorlist(ProductSearchDTO dto);
	int vendorcount(ProductSearchDTO dto);
	
	//창고조회
	public List<ProductDTO> getWarehouselist(ProductSearchDTO dto);
	int warehousecount(ProductSearchDTO dto);
	
	//상품등록 (옵션 등록)
	public void goodsinsert(ProdInsertVO vo);
	
	//상품리스트 조회
	public List<ProductDTO> getProductlist(ProductSearchDTO dto);
	int productcount(ProductSearchDTO vo);
	
	//상품상세정보 조회
	List<ProductDTO>getGoodsOption(String goodsCode, int companyNum);
	
	
	//상품수정 (옵션 수정 및 등록 = 사용유무)
	public void goodUpdate(ProdUpdateVO vo);
	
	//상품별 재고 조회
	public List<ProductDTO> getGoodsNum(ProductSearchDTO dto);
	int goodsNumCount(ProductSearchDTO vo);
	
	//상품 lot 조회 
	public List<ProductDTO> getGoodsLotNum(ProductSearchDTO dto);
	int goodsLotNumCount(ProductSearchDTO vo);
	
	
}
