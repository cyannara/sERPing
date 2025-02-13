package com.beauty1nside.erp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MovieDTO {
	private Long seqMovie;
	private Long rnum;
	private Long rank;
	private Long rankinten;
	private String rankoldandnew;
	private Long moviecd;
	private String movienm;
	private String opendt;
	private Long salesamt;
	private Double salesshare;
	private Long salesinten;
	private Double saleschange;
	private Long salesacc;
	private Long audicnt;
	private Long audiinten;
	private Double audichange;
	private Long audiacc;
	private Long scrncnt;
	private Long showcnt;
	private String thisdate;
}