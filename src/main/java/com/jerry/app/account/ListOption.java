package com.jerry.app.account;

public class ListOption {
	private Long account_num;
	private Integer order; // 0이면 desc 1이면 asc
	private String trade_type;

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

	public Integer getOrder() {
		return order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}

}
