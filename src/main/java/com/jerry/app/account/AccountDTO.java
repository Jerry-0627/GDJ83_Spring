package com.jerry.app.account;

import java.sql.Date;

public class AccountDTO {
	private Long account_num;
	private String user_id;
	private Long product_num;
	private Long balance;
	private Date account_date;

	public Long getAccount_num() {
		return account_num;
	}

	public void setAccount_num(Long account_num) {
		this.account_num = account_num;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public Long getProduct_num() {
		return product_num;
	}

	public void setProduct_num(Long product_num) {
		this.product_num = product_num;
	}

	public Long getBalance() {
		return balance;
	}

	public void setBalance(Long balance) {
		this.balance = balance;
	}

	public Date getAccount_date() {
		return account_date;
	}

	public void setAccount_date(Date account_date) {
		this.account_date = account_date;
	}

}
