package com.jerry.app.boards.notice;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jerry.app.boards.BoardDAO;
import com.jerry.app.boards.BoardDTO;
import com.jerry.app.util.PageDTO;

@Repository
//이름 지정 @repository("[이름]")
public class NoticeDAO implements BoardDAO {
	// noticeDAO가 boardDAO를 구현했다.

	@Autowired
	private SqlSession sqlSession;

	private final String NAMESPACE = "com.jerry.app.boards.notice.NoticeDAO.";

	@Override
	public List<BoardDTO> getList(PageDTO pageDTO) throws Exception {
		return sqlSession.selectList(NAMESPACE + "getList", pageDTO);
	}

	@Override
	public Long getTotalRowCount(PageDTO pageDTO) throws Exception {
		return sqlSession.selectOne(NAMESPACE + "getTotalRowCount", pageDTO);
	}

	@Override
	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception {
		return sqlSession.selectOne(NAMESPACE + "getDetail", boardDTO);
	}

	@Override
	public int hitUpdate(BoardDTO boardDTO) throws Exception {
		return sqlSession.update(NAMESPACE + "hitUpdate", boardDTO);
	}

	@Override
	public int doDelete(BoardDTO boardDTO) throws Exception {
		return sqlSession.delete(NAMESPACE + "doDelete", boardDTO);
	}

	@Override
	public int doUpdate(BoardDTO boardDTO) throws Exception {
		return sqlSession.update(NAMESPACE + "doUpdate", boardDTO);
	}

	@Override
	public int doAdd(BoardDTO boardDTO) throws Exception {
		return sqlSession.insert(NAMESPACE + "doAdd", boardDTO);
	}
}
