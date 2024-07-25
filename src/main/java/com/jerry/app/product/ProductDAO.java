package com.jerry.app.product;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jerry.app.member.MemberDTO;
import com.jerry.app.util.CommentPageDTO;
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

	public Long getproductnum() throws Exception {
		return sqlSession.selectOne(NAMESPACE + "getproductnum");
	}

	public int doadd(ProductDTO productDTO) throws Exception {

		return sqlSession.insert(NAMESPACE + "doadd", productDTO);

	}

	public int doaddfile(ProductFileDTO productFileDTO) throws Exception {

		return sqlSession.insert(NAMESPACE + "doaddfile", productFileDTO);

	}

	public int dodelete(ProductDTO productDTO) throws Exception {

		return sqlSession.delete(NAMESPACE + "dodelete", productDTO);
	}

	public int doupdate(ProductDTO productDTO) throws Exception {
		return sqlSession.update(NAMESPACE + "doupdate", productDTO);
	}

	public int addWish(Map<String, Object> map) throws Exception {
		return sqlSession.insert(NAMESPACE + "addWish", map);
	}

	public List<ProductDTO> wishList(MemberDTO memberDTO) throws Exception {
		return sqlSession.selectList(NAMESPACE + "wishList", memberDTO);
	}

	public int deleteWishList(Map<String, Object> map) throws Exception {
		return sqlSession.delete(NAMESPACE + "deleteWishList", map);
	}

	public int commentAdd(ProductCommentDTO pCommentDTO) throws Exception {
		return sqlSession.insert(NAMESPACE + "commentAdd", pCommentDTO);
	}

	public List<ProductCommentDTO> commentList(CommentPageDTO commentPageDTO) throws Exception {
		return sqlSession.selectList(NAMESPACE + "commentList", commentPageDTO);
	}

	public Long commentTotalCount(CommentPageDTO commentPageDTO) throws Exception {
		return sqlSession.selectOne(NAMESPACE + "commentTotalCount", commentPageDTO);
	}

	public int commentDelete(ProductCommentDTO productCommentDTO) throws Exception {
		return sqlSession.delete(NAMESPACE + "commentDelete", productCommentDTO);
	}
}
