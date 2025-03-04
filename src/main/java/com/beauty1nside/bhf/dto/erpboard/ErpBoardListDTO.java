package com.beauty1nside.bhf.dto.erpboard;

import java.sql.Date;

import lombok.Data;

@Data
public class ErpBoardListDTO {

	private int boardId;
	private String boardTitle;
	private String boardContent;
	private String boardCategory;
	private int employeeNum;
	private Date boardDate;
	private int companyNum;
	private String employeeName;
	
}
