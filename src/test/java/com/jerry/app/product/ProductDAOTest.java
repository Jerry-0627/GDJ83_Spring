package com.jerry.app.product;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.jerry.app.DefaultTest;

public class ProductDAOTest extends DefaultTest {

	@Autowired
	private ProductDAO productDAO;

	@Test
	public void pageTest() throws Exception {
		long perPage = 10L;
		long totalCount = productDAO.getnum();
		System.out.println(productDAO.getnum());
		long totalPage = totalCount / perPage;

		if (totalCount % perPage != 0) {
			totalPage++;
		}

		System.out.println("Count : " + totalCount);
		System.out.println("Page : " + totalPage);
		System.out.println("이것이 pageTest");
//		long totalPage1 = (long) Math.ceil(totalCount / perPage);
//		System.out.println(totalPage1);
	}

	@Test
	public void addTest() throws Exception {
		ProductDTO productDTO = new ProductDTO();
		for (int i = 0; i < 100; i++) {
			productDTO.setProduct_name("자유입출금" + i);
			double r = ((int) (Math.random() * 1000)) / 100.0;
			productDTO.setProduct_rate(r);
			productDTO.setProduct_ex("상세설명" + i);
			productDAO.doadd(productDTO);
			Thread.sleep(500);
		}
		System.out.println("Finish");
	}

//	@Test
//	public void getDetailTest() throws Exception {
//		ProductDTO productDTO = new ProductDTO();
//		productDTO.setProduct_num(31);
//		productDTO = productDAO.getdetail(productDTO);
//		System.out.println("Test");
//		// 단정문
//		assertNotNull(productDTO);
//	}
}
