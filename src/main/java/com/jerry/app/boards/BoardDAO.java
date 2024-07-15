package com.jerry.app.boards;

import java.util.List;

import com.jerry.app.util.PageDTO;

public interface BoardDAO {

	// NoticeDAO, QnaDAO

	// totalCount
	public abstract Long getTotalRowCount(PageDTO pageDTO) throws Exception;

	// list
	public abstract List<BoardDTO> getList(PageDTO pageDTO) throws Exception;
	// public 과 abstract는 interface 내에서 생략이 가능하다.
	// List<BoardDTO> list() throws Exception;

	// add
	public abstract int doAdd(BoardDTO boardDTO) throws Exception;

	// hit update
	public abstract int hitUpdate(BoardDTO boardDTO) throws Exception;

	// update
	public abstract int doUpdate(BoardDTO boardDTO) throws Exception;

	// delete
	public abstract int doDelete(BoardDTO boardDTO) throws Exception;

	// detail
	public abstract BoardDTO getDetail(BoardDTO boardDTO) throws Exception;

}
