package com.jerry.app.account;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAO {
	@Autowired
	private SqlSession sqlSession;

	private final String Namespace = "com.jerry.app.account.AccountDAO";

	public void add() {

	}
}
