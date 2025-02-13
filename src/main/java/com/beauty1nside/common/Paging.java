package com.beauty1nside.common;

import lombok.Data;

@Data
public class Paging {
	int pageUnit=10 ;  //한페이지 출력할 레코드 건수
	int pageSize=10 ;  //페이지번호 수 (5) 1~ 5까지
	int lastPage;      //마지막 페이지번호
	int totalRecord;  //전체 레코드건수
	Integer page = 1;	  //현재 페이지
	int startPage;  //페이지그룹내에서 시작페이지번호
	int endPage;  //페이지그룹내에서 마지막페이지번호
	int first;
	int last;

	//이전페이지 구하기
	public int getFirst() {
		first = (getPage() - 1) * getPageUnit() + 1;
		return first;
	}

	//다음페이지 구하기
	public int getLast() {
		last = getPage() * getPageUnit();
		return last;
	}

	public int getPageUnit() {
		return pageUnit;
	}

	public void setPageUnit(int pageUnit) {
		this.pageUnit = pageUnit;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	//제일 마지막 페이지 구하는거
	public int getLastPage() {
		lastPage = totalRecord / pageUnit +
				   ( totalRecord % pageUnit>0 ? 1 : 0 );
		return lastPage;
	}

	public void setLastPage(int lastPage) {
		this.lastPage = lastPage;
	}

	public int getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	//현제 페이지 그룹에서 첫페이지 구하는거  1 2 3 4 5 이면 1이 나옴 [공식임]
	public int getStartPage() {
		startPage = (page-1)/pageSize * pageSize + 1;
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	//현제 페이지 그룹에서 마지막 페이지 구하는거    1 2 3 4 5  이면 5가 나옴 [공식임]
	public int getEndPage() {
		endPage = (page-1)/pageSize  * pageSize  + pageSize ;
		if ( endPage > getLastPage() )
			endPage = getLastPage() ;
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

}