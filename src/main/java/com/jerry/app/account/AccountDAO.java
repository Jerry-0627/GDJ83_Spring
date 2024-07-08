package com.jerry.app.account;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jerry.app.member.MemberDTO;

@Repository
public class AccountDAO {
	@Autowired
	private SqlSession sqlSession;

	// 어느 맵퍼를 쓸거냐
	// 마지막에 .을 넣어야함. 이것의 아이디를 써야하기 때문임.
	private final String Namespace = "com.jerry.app.account.AccountDAO.";

	public int add(AccountDTO accountDTO) throws Exception {
		return sqlSession.insert(Namespace + "add", accountDTO);
	}

	public List<AccountDTO> list(MemberDTO memberDTO) throws Exception {
		return sqlSession.selectList(Namespace + "list", memberDTO);
	}
}
