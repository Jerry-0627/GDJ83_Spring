package com.jerry.app.trades;

import java.sql.Date;

public class TradeDTO {
	// 거래번호
	private Long trade_num;

	// 거래일
	private Date trade_date;

	// 거래금액
	private Long trade_amount;

	// 거래후 잔액
	private Long balance;

	// 입출금 구분, (0:입금, 1:출금)
	private String trade_type;

	// 계좌번호
	private Long account_num;

	private Long receive_num;

	public Long getBalance() {
		return balance;
	}

	public void setBalance(Long balance) {
		this.balance = balance;
	}

	public Long getReceive_num() {
		return receive_num;
	}

	public void setReceive_num(Long receive_num) {
		this.receive_num = receive_num;
	}

	public Long getTrade_num() {
		return trade_num;
	}

	public void setTrade_num(Long trade_num) {
		this.trade_num = trade_num;
	}

	public Date getTrade_date() {
		return trade_date;
	}

	public void setTrade_date(Date trade_date) {
		this.trade_date = trade_date;
	}

	public Long getTrade_amount() {
		return trade_amount;
	}

	public void setTrade_amount(Long trade_amount) {
		this.trade_amount = trade_amount;
	}

	public String getTrade_type() {
		return trade_type;
	}

	public void setTrade_type(String trade_type) {
		this.trade_type = trade_type;
	}

	public Long getAccount_num() {
		return account_num;
	}

	public void setAccount_num(Long account_num) {
		this.account_num = account_num;
	}

}