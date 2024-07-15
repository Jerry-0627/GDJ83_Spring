package com.jerry.app.product;

public class ProductDTO {

	private Integer product_num;
	private String product_name;
	private double product_rate;
	private String product_ex;

	public Integer getProduct_num() {
		return product_num;
	}

	public void setProduct_num(Integer product_num) {
		this.product_num = product_num;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public double getProduct_rate() {
		return product_rate;
	}

	public void setProduct_rate(double product_rate) {
		this.product_rate = product_rate;
	}

	public String getProduct_ex() {
		return product_ex;
	}

	public void setProduct_ex(String product_ex) {
		this.product_ex = product_ex;
	}

}
