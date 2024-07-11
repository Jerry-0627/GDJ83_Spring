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
		// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
		// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
		// 1. 총 Row 개수로 총페이지 수 구하기.

		long curPageRowCount = 10L; // 하나의 Page에 보여줄 Row의 개수

		long pageFirstRowNum = (page - 1) * curPageRowCount + 1; // Page에 나타낼 첫번째 Row 번호
		long pageLastRowNum = page * curPageRowCount; // Page에 나타낼 마지막 Row 번호

		long totalRowCount = productDAO.getnum(); // Row의 개수
		long totalPageCount = totalRowCount / curPageRowCount; // Page의 개수

		// 하나의 Page에서 Row의 시작 값과 마지막 값 세팅
		PageDTO pageDTO = new PageDTO();
		pageDTO.setStartRow(pageFirstRowNum);
		pageDTO.setLastRow(pageLastRowNum);

		// 잔여 Row가 있으면 잔여 Row를 담기 위한 페이지를 하나 더 만든다.
		if (totalRowCount % curPageRowCount != 0) {
			totalPageCount++;
		}

		System.out.println("RowCount : " + totalRowCount);
		System.out.println("PageCount : " + totalPageCount);

		// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
		// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
		// 2. 총 페이지수로 총 블럭 수 구하기
		long blockPageCount = 5L;
		long totalBlockCount = totalPageCount / blockPageCount;
		if (totalPageCount % blockPageCount != 0) {
			totalBlockCount++;
		}

		// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
		// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
		// 3. 현재 페이지 번호로 현재 블럭 번호 구하기.
		long curBlockNum = page / blockPageCount;
		if (page % blockPageCount != 0) {
			curBlockNum++;
		}

		// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
		// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
		// 4. 현재 블럭 번호로 해당 블럭의 페이지 시작번호와 끝번호 구하기.
		long blockFirstPage = curBlockNum * blockPageCount - (blockPageCount - 1);
		long blockLastPage = curBlockNum * blockPageCount;

		// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
		// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
		// 5. 이전 다음 페이지가 있는지 판단하기.
		boolean prePage = true;
		boolean nextPage = true;
		// 현재 페이지에 해당하는 블록의 첫번째 페이지 보다 
		
		if (page <= blockPageCount) {
			prePage = false;
		}
		
		long lastBlockFirstPage = totalBlockCount*blockPageCount - (blockPageCount - 1);
		
		if (page >= lastBlockFirstPage) {
			nextPage = false;
			blockLastPage = totalPageCount;
		}

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", productDAO.getlist(pageDTO));
		map.put("blockFirstPage", blockFirstPage);
		map.put("blockLastPage", blockLastPage);
		map.put("prePage", prePage);
		map.put("nextPage", nextPage);
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
