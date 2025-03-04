package com.beauty1nside.bsn.dto.cs;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class BsnCsReturningDetailDTO {

	private String csReturningGoodsId;
	private String returningCode;
	private String returningDetailCode;
	private String goodsCode;
	private String goodsName;
	private String optionCode;
	private String optionName;
	private int returningQnt;
	private int warehousingQnt;
	private int disuseQnt;
	private Date completionDate;
	private String exchangeReturningChoice;
	private String optionBarcode;
	private String goodsLotNum;
	private String returningReason;
	private String warehouseId;
	private int employee_num;
	private int companyNum;
	


}
