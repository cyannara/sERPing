package com.beauty1nside.erp.service;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MovieListDTO {
	
	private List<MovieDTO> list;
	//private String thisdate;

}
