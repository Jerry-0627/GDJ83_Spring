package com.jerry.app.boards.qna;

import com.jerry.app.boards.BoardDTO;

public class QnaDTO extends BoardDTO {

	private Long ref;
	private Long step;
	private Long depth;
	private Integer del;

	public Integer getDel() {
		return del;
	}

	public void setDel(Integer del) {
		this.del = del;
	}

	public Long getRef() {
		return ref;
	}

	public void setRef(Long ref) {
		this.ref = ref;
	}

	public Long getStep() {
		return step;
	}

	public void setStep(Long step) {
		this.step = step;
	}

	public Long getDepth() {
		return depth;
	}

	public void setDepth(Long depth) {
		this.depth = depth;
	}

}
