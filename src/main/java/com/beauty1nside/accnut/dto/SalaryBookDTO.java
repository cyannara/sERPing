package com.beauty1nside.accnut.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class SalaryBookDTO {
	
	String salaryAccountBookCode;
	String employeeCode;
	String employeeName;
	String department;
	int salary;
	int excessAllowance;
	double bonus;
	int incidentalCost;
	int deductionItem;
	int paymentAmount;
	Date paymentPrearranged_date;
	String paymentAlternative;
	String payer;
	int companyNum;
		
}
