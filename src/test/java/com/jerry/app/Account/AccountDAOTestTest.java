package com.jerry.app.Account;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.jerry.app.DefaultTest;
import com.jerry.app.account.AccountDAO;
import com.jerry.app.account.AccountDTO;

public class AccountDAOTestTest extends DefaultTest {

	@Autowired
	private AccountDAO accountDAO;

	@Test
	public void AccountTest() throws Exception {
		AccountDTO accountDTO = new AccountDTO();
		accountDTO.setAccount_num(3L);
		accountDTO = accountDAO.detail(accountDTO);
		assertNotNull(accountDTO);
	}

}
