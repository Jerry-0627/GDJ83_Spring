package com.jerry.app.boards;

import java.sql.Date;

public class CommentDTO {

	private Long board_num;
	private String board_writer;
	private Date create_date;
	private String board_contents;

	public Long getBoard_num() {
		return board_num;
	}

	public void setBoard_num(Long board_num) {
		this.board_num = board_num;
	}

	public String getBoard_writer() {
		return board_writer;
	}

	public void setBoard_writer(String board_writer) {
		this.board_writer = board_writer;
	}

	public Date getCreate_date() {
		return create_date;
	}

	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}

	public String getBoard_contents() {
		return board_contents;
	}

	public void setBoard_contents(String board_contents) {
		this.board_contents = board_contents;
	}

}
