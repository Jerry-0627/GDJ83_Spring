package com.jerry.app.product;

import com.jerry.app.files.FileDTO;

public class ProductFileDTO extends FileDTO {
	private Long product_num;

	public Long getProduct_num() {
		return product_num;
	}

	public void setProduct_num(Long product_num) {
		this.product_num = product_num;
	}

}
