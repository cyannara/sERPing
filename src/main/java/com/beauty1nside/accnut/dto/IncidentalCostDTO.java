package com.beauty1nside.accnut.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class IncidentalCostDTO {
	String incidentalCostCode;
	String department;
	String section;
	String cardNum;
	int amount;
	String contents;
	Date registerDate;
	Date payDate;
	String image;
	String processAlternative;
	int employeeNum;
	String employeeName;
	String accountCategory;
	int confirmer;
	int companyNum;
}
