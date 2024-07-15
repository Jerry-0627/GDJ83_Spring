package com.jerry.app.notice;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jerry.app.util.PageDTO;

@Repository
public class NoticeDAO {

	@Autowired
	private SqlSession sqlSession;

	private final String NAMESPACE = "com.jerry.app.notice.NoticeDAO.";

	public List<NoticeDTO> getList(PageDTO pageDTO) throws Exception {
		return sqlSession.selectList(NAMESPACE + "getList", pageDTO);
	}

	public long getTotalRowCount(PageDTO pageDTO) throws Exception {
		return sqlSession.selectOne(NAMESPACE + "getTotalRowCount", pageDTO);
	}

	public NoticeDTO getDetail(NoticeDTO noticeDTO) throws Exception {
		return sqlSession.selectOne(NAMESPACE + "getDetail", noticeDTO);
	}

	public int hitUpdate(NoticeDTO noticeDTO) throws Exception {
		return sqlSession.update(NAMESPACE + "hitUpdate", noticeDTO);
	}

	public int doDelete(NoticeDTO noticeDTO) throws Exception {
		return sqlSession.delete(NAMESPACE + "doDelete", noticeDTO);
	}

	public int doUpdate(NoticeDTO noticeDTO) throws Exception {
		return sqlSession.update(NAMESPACE + "doUpdate", noticeDTO);
	}

	public int doAdd(NoticeDTO noticeDTO) throws Exception {
		return sqlSession.insert(NAMESPACE + "doAdd", noticeDTO);
	}
}
