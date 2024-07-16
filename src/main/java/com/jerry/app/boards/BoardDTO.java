package com.jerry.app.boards;

import java.sql.Date;

public class BoardDTO {

	private Long board_num;
	private String board_writer;
	private String board_title;
	private Date create_date;
	private Date update_date;
	private Long board_hit;
	private String board_contents;
	private String board_category;
	private Integer del;

	public Integer getDel() {
		if (this.del == null) {
			this.del = 0;
		}
		return del;
	}

	public void setDel(Integer del) {
		this.del = del;
	}

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

	public String getBoard_title() {
		return board_title;
	}

	public void setBoard_title(String board_title) {
		this.board_title = board_title;
	}

	public Date getCreate_date() {
		return create_date;
	}

	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}

	public Date getUpdate_date() {
		return update_date;
	}

	public void setUpdate_date(Date update_date) {
		this.update_date = update_date;
	}

	public Long getBoard_hit() {
		return board_hit;
	}

	public void setBoard_hit(Long board_hit) {
		this.board_hit = board_hit;
	}

	public String getBoard_contents() {
		return board_contents;
	}

	public void setBoard_contents(String board_contents) {
		this.board_contents = board_contents;
	}

	public String getBoard_category() {
		return board_category;
	}

	public void setBoard_category(String board_category) {
		this.board_category = board_category;
	}

}
