package com.jerry.app.product;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.jerry.app.DefaultTest;

public class ProductDAOTest extends DefaultTest {

	@Autowired
	private ProductDAO productDAO;

	@Test
	public void getDetailTest() throws Exception {
		ProductDTO productDTO = new ProductDTO();
		productDTO.setProduct_num(31);
		productDTO = productDAO.getdetail(productDTO);
		System.out.println("Test");
		// 단정문
		assertNotNull(productDTO);
	}
}
