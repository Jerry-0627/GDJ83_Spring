package com.jerry.app.product;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jerry.app.util.PageDTO;

@Service
public class ProductService {
	@Autowired
	// DAO가 필요ㅐ서
	private ProductDAO productDAO;
	private PageDTO pageDTO;

	public Map<String, Object> getlist(String kind, String search, Long page) throws Exception {
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
		if (search == null) {
			search = "";
		}

		long perPage = 10L; // 하나의 Page에 보여줄 Row의 개수
		long startRow = (page - 1) * perPage + 1; // 첫번째 Page의 번호
		long lastRow = page * perPage; // 마지막 Page 번호

		// 하나의 Page에서 Row의 시작 값과 마지막 값 세팅
		PageDTO pageDTO = new PageDTO();
		pageDTO.setStartRow(startRow);
		pageDTO.setLastRow(lastRow);
		pageDTO.setKind(kind);
		pageDTO.setSearch(search);

		long totalCount = productDAO.getnum(pageDTO); // Row의 개수

		// 찾기 쉽기 위해 키로 넣음. Map 사용 List와 페이지 개수를 Controller로 보냄
		Map<String, Object> map = pageDTO.makeNum(totalCount, perPage, page);
		map.put("list", productDAO.getlist(pageDTO));
		map.put("kind", kind);
		map.put("search", search);

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
