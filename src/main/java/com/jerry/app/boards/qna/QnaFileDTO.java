package com.jerry.app.boards.qna;

import com.jerry.app.files.FileDTO;

public class QnaFileDTO extends FileDTO {
	private Long board_num;

	public Long getBoard_num() {
		return board_num;
	}

	public void setBoard_num(Long board_num) {
		this.board_num = board_num;
	}

}
