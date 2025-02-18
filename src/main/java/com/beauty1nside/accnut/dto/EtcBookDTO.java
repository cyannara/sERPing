package com.beauty1nside.accnut.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class EtcBookDTO {
	
	String etcPaymentCode;
	String section;
	String department;
	Date timeLimit;
	int amount;
	String  paymentAlternative;
	String  giroNum;
	int companyNum;
}
