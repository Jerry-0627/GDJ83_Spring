package com.jerry.app.product;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
	@Autowired
	// DAO가 필요ㅐ서
	private ProductDAO productDAO;
	private PageDTO pageDTO;

	public Map<String, Object> getlist(Long page) throws Exception {
		// page값이 1이면 첫번째 숫자는 1 두번째 숫자는 10
		// page값이 2라면 첫번째 숫자는 11 두번째 숫자는 20
		// .
		// .
		// . 이것을 계산하는 식을 만들어야함

		if (page == null) {
			page = 1L;
		}
		if (page < 1) {
			page = 1L;
		}

		long perPage = 10L; // 하나의 Page에 보여줄 Row의 개수
		long startRow = (page - 1) * perPage + 1; // 첫번째 Page의 번호
		long lastRow = page * perPage; // 마지막 Page 번호
		long totalCount = productDAO.getnum(); // Row의 개수
		long totalPage = totalCount / perPage; // Page의 개수

		// 하나의 Page에서 Row의 시작 값과 마지막 값 세팅
		PageDTO pageDTO = new PageDTO();
		pageDTO.setStartRow(startRow);
		pageDTO.setLastRow(lastRow);

		// 1. 총 개수로 총 페이지 수 구하기
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

		// 찾기 쉽기 위해 키로 넣음. Map 사용 List와 페이지 개수를 Controller로 보냄
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", productDAO.getlist(pageDTO));
		map.put("getnum", totalPage);
		map.put("startNum", startNum);
		map.put("lastNum", lastNum);
		map.put("pre", pre);
		map.put("next", next);

		return map;
	}

	public ProductDTO getdetail(ProductDTO productDTO) throws Exception {
		ProductDTO dto = productDAO.getdetail(productDTO);

		return dto;
	}

	public int doadd(ProductDTO productDTO) throws Exception {
		int result = productDAO.doadd(productDTO);
		return result;
	}

	public int dodelete(ProductDTO productDTO) throws Exception {
		int result = productDAO.dodelete(productDTO);
		return result;
	}

	public int doupdate(ProductDTO productDTO) throws Exception {
		int result = productDAO.doupdate(productDTO);
		return result;
	}
}
