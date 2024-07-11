package com.jerry.app.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
	@Autowired
	// DAO가 필요ㅐ서
	private ProductDAO productDAO;
	private PageDTO pageDTO;

	public List<ProductDTO> getlist(Long page) throws Exception {
		// page값이 1이면 첫번째 숫자는 1 두번째 숫자는 10
		// page값이 2라면 첫번째 숫자는 11 두번째 숫자는 20
		// .
		// .
		// . 이것을 계산하는 식을 만들어야함

		if (page == null) {
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

		// 잔여 Row 보여주게 하기 위함.
		if (totalCount % perPage != 0) {
			totalPage++;
		}

		System.out.println("RowCount : " + totalCount);
		System.out.println("PageCount : " + totalPage);

		// long과 Long의 차이는 어떠한 것들이 있을까?

		List<ProductDTO> ar = productDAO.getlist(pageDTO);

		return ar;
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
