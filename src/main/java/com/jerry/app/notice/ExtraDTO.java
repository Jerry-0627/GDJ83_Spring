package com.jerry.app.notice;

public class ExtraDTO {
	private String kind;
	private String search;
	private Long page;
	private Long pageFirstRow;
	private Long pageLastRow;
	
	
	
	




	public Long getPageFirstRow() {
		return pageFirstRow;
	}

	public void setPageFirstRow(Long pageFirstRow) {
		this.pageFirstRow = pageFirstRow;
	}

	public Long getPageLastRow() {
		return pageLastRow;
	}

	public void setPageLastRow(Long pageLastRow) {
		this.pageLastRow = pageLastRow;
	}

	public Long getPage() {
		return page;
	}

	public void setPage(Long page) {
		this.page = page;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

}
