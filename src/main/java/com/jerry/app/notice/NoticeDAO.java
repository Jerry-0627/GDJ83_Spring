package com.jerry.app.notice;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class NoticeDAO {

	@Autowired
	private SqlSession sqlSession;

	private final String NAMESPACE = "com.jerry.app.notice.NoticeDAO.";

	public List<NoticeDTO> getList(ExtraDTO extraDTO) throws Exception {
		return sqlSession.selectList(NAMESPACE + "getList", extraDTO);
	}
	
	public long getTotalRowCount(ExtraDTO extraDTO) throws Exception{
		return sqlSession.selectOne(NAMESPACE + "getTotalRowCount", extraDTO);
	}

	public NoticeDTO getDetail(NoticeDTO noticeDTO) throws Exception {
		return sqlSession.selectOne(NAMESPACE + "getDetail", noticeDTO);
	}
	
	public int hitUpdate(NoticeDTO noticeDTO) throws Exception{
		return sqlSession.update(NAMESPACE + "hitUpdate", noticeDTO);
	}
	
	public int doDelete(NoticeDTO noticeDTO) throws Exception{
		return sqlSession.delete(NAMESPACE + "doDelete", noticeDTO);
	}
	
	public int doUpdate(NoticeDTO noticeDTO) throws Exception{
		return sqlSession.update(NAMESPACE + "doUpdate", noticeDTO);
	}

	public int doAdd(NoticeDTO noticeDTO) throws Exception {
		return sqlSession.insert(NAMESPACE + "doAdd", noticeDTO);
	}
}
