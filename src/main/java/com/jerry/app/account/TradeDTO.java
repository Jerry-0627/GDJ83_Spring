package com.jerry.app.account;

import java.sql.Date;

public class TradeDTO {

	private Long trade_num;
	private Long account_num_me;
	private Long account_num_you;
	private String trade_type;
	private Long trade_amount;
	private Long balance;
	private Date trade_date;
	private AccountDTO accountDTO;

	public Long getAccount_num_me() {
		return account_num_me;
	}

	public void setAccount_num_me(Long account_num_me) {
		this.account_num_me = account_num_me;
	}

	public Long getAccount_num_you() {
		return account_num_you;
	}

	public void setAccount_num_you(Long account_num_you) {
		this.account_num_you = account_num_you;
	}

	public AccountDTO getAccountDTO() {
		return accountDTO;
	}

	public void setAccountDTO(AccountDTO accountDTO) {
		this.accountDTO = accountDTO;
	}

	public Long getTrade_num() {
		return trade_num;
	}

	public void setTrade_num(Long trade_num) {
		this.trade_num = trade_num;
	}

	/*
	 * public Long getAccount_num() { return account_num; }
	 * 
	 * public void setAccount_num(Long account_num) { this.account_num =
	 * account_num; }
	 */

	public String getTrade_type() {
		return trade_type;
	}

	public void setTrade_type(String trade_type) {
		this.trade_type = trade_type;
	}

	public Long getTrade_amount() {
		return trade_amount;
	}

	public void setTrade_amount(Long trade_amount) {
		this.trade_amount = trade_amount;
	}

	public Long getBalance() {
		return balance;
	}

	public void setBalance(Long balance) {
		this.balance = balance;
	}

	public Date getTrade_date() {
		return trade_date;
	}

	public void setTrade_date(Date trade_date) {
		this.trade_date = trade_date;
	}

}
