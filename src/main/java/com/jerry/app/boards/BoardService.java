package com.jerry.app.boards;

import java.util.List;

import com.jerry.app.util.PageDTO;

public interface BoardService {

	// list
	public List<BoardDTO> getList(PageDTO pageDTO) throws Exception;

	// add
	public int doAdd(BoardDTO boardDTO) throws Exception;

	// hit
	public int hitUpdate(BoardDTO boardDTO) throws Exception;

	// update
	public int doUpdate(BoardDTO boardDTO) throws Exception;

	// delete
	public int delete(BoardDTO boardDTO) throws Exception;

	public BoardDTO detail() throws Exception;
}
