package com.jerry.app.product;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jerry.app.util.PageDTO;

@Repository
public class ProductDAO {

	@Autowired
	private SqlSession sqlSession;

	private final String NAMESPACE = "com.jerry.app.product.ProductDAO.";

	public List<ProductDTO> getlist(PageDTO pageDTO) throws Exception {
		// productDTO가 여러개여서 List로 받는거임
		return sqlSession.selectList(NAMESPACE + "getlist", pageDTO);
	}

	public Long getnum(PageDTO pageDTO) throws Exception {
		return sqlSession.selectOne(NAMESPACE + "getnum", pageDTO);
	}

	public ProductDTO getdetail(ProductDTO productDTO) throws Exception {
		return sqlSession.selectOne(NAMESPACE + "getdetail", productDTO);
	}

	public int doadd(ProductDTO productDTO) throws Exception {

		return sqlSession.insert(NAMESPACE + "doadd", productDTO);

	}

	public int dodelete(ProductDTO productDTO) throws Exception {

		return sqlSession.delete(NAMESPACE + "dodelete", productDTO);
	}

	public int doupdate(ProductDTO productDTO) throws Exception {
		return sqlSession.update(NAMESPACE + "doupdate", productDTO);
	}
}
