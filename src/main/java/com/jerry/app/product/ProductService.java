package com.jerry.app.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jerry.app.util.PageDTO;

@Service
public class ProductService {
	@Autowired
	// DAO가 필요ㅐ서
	private ProductDAO productDAO;
	private PageDTO pageDTO;

	public List<ProductDTO> getlist(PageDTO pageDTO) throws Exception {
		pageDTO.makeRow();

		long totalCount = productDAO.getnum(pageDTO);

		pageDTO.makeNum(totalCount);

		return productDAO.getlist(pageDTO);
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
