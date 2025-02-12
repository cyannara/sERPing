package com.beauty1nside.common;

import java.util.List;

import lombok.Data;

@Data
public class GridData<T> {
	List<T> createdRows;
	List<T> deletedRows;
	List<T> updatedRows;
}
