package com.jerry.app.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

	@Autowired
	private AccountDAO accountDAO;
	
	public int add(AccountDTO accountDTO) throws Exception{
		return accountDAO.add(accountDTO);
	}
}
