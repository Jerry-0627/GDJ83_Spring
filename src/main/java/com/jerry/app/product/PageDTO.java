package com.jerry.app.product;

public class PageDTO {

	private long startRow;
	private long lastRow;
	private Long order;
	private Long page;
	
	

	public Long getPage() {
		return page;
	}

	public void setPage(Long page) {
		this.page = page;
	}

	public Long getOrder() {
		return order;
	}

	public void setOrder(Long order) {
		this.order = order;
	}

	public long getStartRow() {
		return startRow;
	}

	public void setStartRow(long startRow) {
		this.startRow = startRow;
	}

	public long getLastRow() {
		return lastRow;
	}

	public void setLastRow(long lastRow) {
		this.lastRow = lastRow;
	}

}
