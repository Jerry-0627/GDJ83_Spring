package com.jerry.app.product;

import com.jerry.app.boards.CommentDTO;

public class ProductCommentDTO extends CommentDTO {

	private Long product_num;

	public Long getProduct_num() {
		return product_num;
	}

	public void setProduct_num(Long product_num) {
		this.product_num = product_num;
	}

}
