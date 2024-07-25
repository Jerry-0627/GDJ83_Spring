package com.jerry.app.boards;

import java.sql.Date;
import java.util.List;

public class BoardDTO extends CommentDTO {

	private String board_title;
	private Date update_date;
	private Long board_hit;
	private String board_category;
	private Integer del;
	private List<BoardFileDTO> boardFileDTOs;

	public String getBoard_title() {
		return board_title;
	}

	public void setBoard_title(String board_title) {
		this.board_title = board_title;
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

	public String getBoard_category() {
		return board_category;
	}

	public void setBoard_category(String board_category) {
		this.board_category = board_category;
	}

	public Integer getDel() {
		return del;
	}

	public void setDel(Integer del) {
		this.del = del;
	}

	public List<BoardFileDTO> getBoardFileDTOs() {
		return boardFileDTOs;
	}

	public void setBoardFileDTOs(List<BoardFileDTO> boardFileDTOs) {
		this.boardFileDTOs = boardFileDTOs;
	}

}
