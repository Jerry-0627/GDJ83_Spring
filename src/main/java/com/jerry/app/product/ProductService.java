package com.jerry.app.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
	@Autowired
	// DAO가 필요ㅐ서
	private ProductDAO productDAO;

	public List<ProductDTO> getlist() throws Exception {
		List<ProductDTO> ar = productDAO.getlist();

		return ar;
	}

	public ProductDTO getdetail(ProductDTO productDTO) throws Exception {
		ProductDTO dto = productDAO.getdetail(productDTO);

		return dto;
	}

	public int doadd(ProductDTO productDTO) throws Exception {
		int i = productDAO.doadd(productDTO);
		return i;
	}
}
