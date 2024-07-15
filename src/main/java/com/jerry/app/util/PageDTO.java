package com.jerry.app.util;

import java.util.HashMap;
import java.util.Map;

public class PageDTO {

	private long startRow;
	private long lastRow;
	private String search;
	private String kind;

	public Map<String, Object> makeNum(long totalCount, long perPage, long page) throws Exception {
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
		long startNum = 0;
		long lastNum = 0;

		startNum = (curBlock - 1) * perBlock + 1;
		lastNum = curBlock * perBlock;

		// 5. 이전 블럭, 다음 블럭 유무 판단
		boolean pre = true; // true면 이전 블럭이 있다.
		if (curBlock == 1) {
			pre = false;
		}
		boolean next = true;
		if (totalBlock == curBlock) {
			next = false;
			lastNum = totalPage;
		}

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("startNum", startNum);
		map.put("lastNum", lastNum);
		map.put("pre", pre);
		map.put("next", next);
		return map;

	}

	public String getSearch() {
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
