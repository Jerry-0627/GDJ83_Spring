package com.jerry.app.account;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

	@Autowired
	private AccountDAO accountDAO;

	public int add(AccountDTO accountDTO) throws Exception {
		// 넘어가기 전에 상품의 계좌번호 생성 과정
		Calendar calendar = Calendar.getInstance(); // 여기 안에 있는 날짱를 accountDTO에 set해서 넣어야함 근데 Long타입임
		accountDTO.setAccount_num(calendar.getTimeInMillis());

		return accountDAO.add(accountDTO);
	}

	public AccountDTO detail(AccountDTO accountDTO) throws Exception {
		return accountDAO.detail(accountDTO);
	}

	public int transfer(AccountDTO accountDTO, TradeDTO tradeDTO) throws Exception {
		int a = 0;

		if (tradeDTO.getTrade_amount() > accountDTO.getBalance()) {
			a = -1;
		} else {

			a += accountDAO.insertMe(tradeDTO);
			a += accountDAO.insertYou(tradeDTO);
			a += accountDAO.updateMe(tradeDTO);
			a += accountDAO.updateYou(tradeDTO);
		}
		System.out.println(a);
		return a;
	}

	public List<TradeDTO> list(ListOption listOption) throws Exception {
		return accountDAO.list(listOption);

	}
}
