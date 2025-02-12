package com.beauty1nside.accnut.dto;

import java.sql.Date;

import lombok.Getter;

@Getter
public class AssetDTO {
	
	String assetsCode;
	String assetsName;
	String section;
	String financialInstitution;
	String financeInformation;
	String owner;
	int amount;
	Date registerDate;
	int quantity;
	int fixturesAmount;

}
