package com.jerry.app.member;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {

	@Autowired
	private SqlSession sqlSession;

	private final String NAMESPACE = "com.jerry.app.member.MemberDAO.";

	public int joinMember(MemberDTO memberDTO) {
		return sqlSession.insert(NAMESPACE + "joinMember", memberDTO);

	}

	public MemberDTO loginMember(MemberDTO memberDTO) throws Exception {
		return sqlSession.selectOne(NAMESPACE + "loginMember", memberDTO);
	}

	public int update(MemberDTO memberDTO) {
		return sqlSession.update(NAMESPACE + "update", memberDTO);
	}

	public int delete(MemberDTO memberDTO) {
		return sqlSession.delete(NAMESPACE + "delete", memberDTO);
	}
}
