package com.jerry.app.util;

public class PageDTO {

	private Long startRow;
	private Long lastRow;
	private String search;
	private String kind;
	private Long page;

	// -------------------------------------------
	private Long startNum;
	private Long lastNum;
	private boolean pre;
	private boolean next;
	private Long perPage = 10L; // 하나의 Page에 보여줄 Row의 개수

	// rownum을 계산하는 메서드
	public void makeRow() throws Exception {
		// page가 null이 올 수 있다 .그런데 이전엔 아래 코드의 위에서 검색하고 내려왔는데, 이번엔 아니다. 따라서 this.getpage를
		// 호출해서 계산해야 한다.

		this.startRow = (this.getPage() - 1) * perPage + 1; // 첫번째 Page의 번호
		this.lastRow = page * perPage; // 마지막 Page 번호. 이번 페이지는 위에소 this.getPage로 계산이 끝난 page가 온다. 따라서 this.page 대신
										// page를 쓴 것이다.

	}

	public void makeNum(long totalCount) throws Exception {
// 1. 총 개수로 총 페이지 수 구하기
		long totalPage = totalCount / perPage; // Page의 개수

		if (totalCount % perPage != 0) {
			totalPage++;
		}
		System.out.println("RowCount : " + totalCount);
		System.out.println("PageCount : " + totalPage);

		// 총 블럭의 수
		long perBlock = 5L; // 한 페이지에 보여줄 Page 번호의 개수
		long totalBlock = 0; // 총 블럭의 수

		// 2.
		totalBlock = (totalPage / 5);
		if (totalPage % perBlock != 0) {
			totalBlock++;
		}

		// 3. 현재 페이지 번호로 현재블럭 번호를 구하기

		long curBlock = 0;

		curBlock = page / perBlock;
		if ((page % perBlock) != 0) {
			curBlock++;
		}

		// 4. 현재 블럭 번호로 시작번호와 끝 번호 구하기

		this.startNum = (curBlock - 1) * perBlock + 1;
		this.lastNum = curBlock * perBlock;

		// 5. 이전 블럭, 다음 블럭 유무 판단

		this.pre = true;
		if (curBlock == 1) {
			pre = false;
		}

		this.next = true;
		if (totalBlock == curBlock) {
			next = false;
			lastNum = totalPage;
		}

	}

	public Long getPerPage() {
		return perPage;
	}

	public void setPerPage(Long perPage) {
		this.perPage = perPage;
	}

	public Long getStartNum() {
		return startNum;
	}

	public void setStartNum(Long startNum) {
		this.startNum = startNum;
	}

	public Long getLastNum() {
		return lastNum;
	}

	public void setLastNum(Long lastNum) {
		this.lastNum = lastNum;
	}

	public boolean isPre() {
		return pre;
	}

	public void setPre(boolean pre) {
		this.pre = pre;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public Long getPage() {
		if (this.page == null || this.page < 1) {
			this.page = 1L;
		}
		return page;
	}

	public void setPage(Long page) {
		this.page = page;
	}

	public String getSearch() {
		if (this.search == null) {
			this.search = "";
		}
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public Long getStartRow() {
		return startRow;
	}

	public void setStartRow(Long startRow) {
		this.startRow = startRow;
	}

	public Long getLastRow() {
		return lastRow;
	}

	public void setLastRow(Long lastRow) {
		this.lastRow = lastRow;
	}

}
