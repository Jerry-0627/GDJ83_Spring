package com.jerry.app.boards.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.jerry.app.boards.BoardDAO;
import com.jerry.app.boards.BoardDTO;
import com.jerry.app.util.PageDTO;

@Service
public class NoticeService {

	@Autowired
	@Qualifier("noticeDAO")
	private BoardDAO boardDAO;

	private PageDTO pageDTO;

	public List<BoardDTO> getList(PageDTO pageDTO) throws Exception {
		pageDTO.makeRow();

		long totalCount = boardDAO.getTotalRowCount(pageDTO); // Row의 개수
		pageDTO.makeNum(totalCount);

		return boardDAO.getList(pageDTO);
	}

	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception {
		return boardDAO.getDetail(boardDTO);
	}

	public int hitUpdate(BoardDTO boardDTO) throws Exception {
		return boardDAO.hitUpdate(boardDTO);
	}

	public int doUpdate(BoardDTO boardDTO) throws Exception {
		return boardDAO.doUpdate(boardDTO);
	}

	public int doDelete(BoardDTO boardDTO) throws Exception {
		return boardDAO.doDelete(boardDTO);
	}

	public int doADD(BoardDTO boardDTO) throws Exception {
		return boardDAO.doAdd(boardDTO);
	}
}
