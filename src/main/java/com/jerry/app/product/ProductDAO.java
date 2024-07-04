package com.jerry.app.product;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDAO {

	@Autowired
	private SqlSession sqlSession;

	private final String NAMESPACE = "com.jerry.app.product.ProductDAO.";

	public List<ProductDTO> getlist() throws Exception {
		return sqlSession.selectList(NAMESPACE + "getlist");
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
