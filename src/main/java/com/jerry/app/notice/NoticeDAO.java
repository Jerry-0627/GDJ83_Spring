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
}
