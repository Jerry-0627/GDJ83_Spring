package com.jerry.app.boards.qna;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jerry.app.boards.BoardDAO;
import com.jerry.app.boards.BoardDTO;
import com.jerry.app.util.PageDTO;

//객체 만드는 어노테이션
@Repository
public class QnaDAO implements BoardDAO {

	// 스프링 빈(객체)를 몽느 풀에서 autowired하면 찾는다. 후순위는 빈의 이름과 변수 이름과 같은 것을 찾는다
	// 빈의 이름은 아무 설정 없으면 클래스 맨 앞이 소문자가 된다.
	@Autowired
	private SqlSession sqlSession;

	private final String NAMESPACE = "com.jerry.app.boards.qna.QnaDAO.";
	// 상수형 타입의 변수명은 전부다 대문자로. 두단어 이상이 합쳐지면 스네이크 표기법

	@Override
	public Long getTotalRowCount(PageDTO pageDTO) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NAMESPACE + "getTotalCount", pageDTO);
	}

	@Override
	public List<BoardDTO> getList(PageDTO pageDTO) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(NAMESPACE + "list", pageDTO);
	}

	@Override
	public int doAdd(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.insert(NAMESPACE + "doAdd", boardDTO);
	}

	@Override
	public int hitUpdate(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.update(NAMESPACE + "hitUpdate", boardDTO);
	}

	@Override
	public int doUpdate(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.update(NAMESPACE + "doUpdate", boardDTO);
	}

	@Override
	public int doDelete(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.delete(NAMESPACE + "doDelete", boardDTO);
	}

	@Override
	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NAMESPACE + "getDetail", boardDTO);
	}
	// 전부 오버라이딩 하던가 abstart 클래스 만들던가

	public int reply(QnaDTO qnaDTO) throws Exception {
		return sqlSession.insert(NAMESPACE + "reply", qnaDTO);
	}

	public int replyUpdate(QnaDTO qnaDTO) throws Exception {
		return sqlSession.update(NAMESPACE + "replyUpdate", qnaDTO);
	}
}
