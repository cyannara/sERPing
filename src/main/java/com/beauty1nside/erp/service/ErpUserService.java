package com.beauty1nside.erp.service;

import java.util.List;
import java.util.Map;

import com.beauty1nside.erp.dto.ContractDTO;
import com.beauty1nside.erp.dto.ErpSearchDTO;
import com.beauty1nside.erp.dto.SubScriptionDTO;
import com.beauty1nside.erp.dto.SubscriptionDetailDTO;
import com.beauty1nside.erp.dto.TaxInvoiceDTO;
import com.beauty1nside.erp.dto.erpSubscriptionInfoListDTO;

/**
 * ERP 사용 회사 CRUD 하는 서비스 인터페이스
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
 *  2025.02.18  표하연          기간 구독 결제 서비스 생성
 *  2025.02.20  표하연          사용계약서 정보를 CR 한다
 *  2025.02.21  표하연          결제 목록을 리드한다
 *  2025.02.26  표하연          구독 결제한 현금영수증, 세금계산서 데이터를 삽입한다
 *  2025.03.04  표하연          정기구독을 등록 한다 ( 결제X )
 *
 *  </pre>
*/
public interface ErpUserService {
	
	/**
     * 고객 구독 정보를 받아옴
     *
     * @param int
     * @return List<erpSubscriptionInfoListDTO>
     */
	public List<erpSubscriptionInfoListDTO> sublist(int comapnyNum); 
	
	/**
     * 회사 계약 상태 여부를 내보냄
     *
     * @param int
     * @return int
     */
	public int subcontact(int comapnyNum);
	
	/**
     * 회사 인사인원 확인
     *
     * @param int
     * @return int
     */
	public int hrlist(int companyNum);
	
	/**
     * 기간 구독 서비스를 등록한다
     *
     * @param Map<String, Object>
     * @return int
     */
	public int periodservicepay(Map<String, Object> requestData);
	
	/**
     * 정기 구독 서비스를 등록한다
     *
     * @param Map<String, Object>
     * @return int
     */
	public int regularRegister(Map<String, Object> requestData);
	
	/**
     * 그룹웨어 옵션 정보를 불러온다
     *
     * @param int
     * @return int
     */
	public int gpoptioninfo(int comapnyNum);
	
	/**
     * 사용계약서를 등록한다
     *
     * @param ContractDTO
     * @return int
     */
	public boolean insertcontract(ContractDTO dto);
	
	/**
     * 사용계약서 정보를 불러온다
     *
     * @param int
     * @return ContractDTO
     */
	public ContractDTO readcontract(int companyNum);
	
	/**
     * 결제 정보 리스트를 조회
     *
     * @param ErpSearchDTO
     * @return List<subscriptioncount>
     */
	public List<SubScriptionDTO> subscriptionlist(ErpSearchDTO searchDTO);
	
	/**
     * 결제 정보 리스트의 갯수를 조회
     *
     * @param ErpSearchDTO
     * @return int
     */
	public int subscriptioncount(ErpSearchDTO searchDTO);
	
	/**
     * 구독리스트의 상세 구독내역을 가져온다
     *
     * @param int
     * @return List<SubscriptionDetailDTO>
     */
	public List<SubscriptionDetailDTO> subscriptionDetail(int subscriptionNum);
	
	/**
     * 구독 결제한 현금영수증, 세금계산서 데이터를 삽입한다
     *
     * @param TaxInvoiceDTO
     * @return boolean
     */
	public boolean insertTaxInvoice(TaxInvoiceDTO dto);

}
