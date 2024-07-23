package com.jerry.app.product;

import java.util.List;

public class ProductDTO {

	private Long product_num;
	private String product_name;
	private double product_rate;
	private String product_ex;
	private List<ProductFileDTO> product_file;
	private List<ProductDTO> product_list;

	public List<ProductDTO> getProduct_list() {
		return product_list;
	}

	public void setProduct_list(List<ProductDTO> product_list) {
		this.product_list = product_list;
	}

	public List<ProductFileDTO> getProduct_file() {
		return product_file;
	}

	public void setProduct_file(List<ProductFileDTO> product_file) {
		this.product_file = product_file;
	}

	public Long getProduct_num() {
		return product_num;
	}

	public void setProduct_num(Long product_num) {
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
