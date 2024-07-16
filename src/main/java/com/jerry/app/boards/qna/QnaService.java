package com.jerry.app.boards.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jerry.app.boards.BoardDTO;
import com.jerry.app.boards.BoardService;
import com.jerry.app.util.PageDTO;

@Service
public class QnaService implements BoardService {

	@Autowired
	private QnaDAO qnaDAO;

	@Override
	public List<BoardDTO> getList(PageDTO pageDTO) throws Exception {
		// 1. Row num을 계산해야 한다.
		pageDTO.makeRow();
		// 2. Page를 계산
		pageDTO.makeNum(qnaDAO.getTotalRowCount(pageDTO));
		return qnaDAO.getList(pageDTO);
	}

	@Override
	public int doAdd(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return qnaDAO.doAdd(boardDTO);
	}

	@Override
	public int hitUpdate(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return qnaDAO.hitUpdate(boardDTO);
	}

	@Override
	public int doUpdate(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return qnaDAO.doUpdate(boardDTO);
	}

	@Override
	public int delete(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return qnaDAO.doDelete(boardDTO);
	}

	@Override
	public BoardDTO detail(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return qnaDAO.getDetail(boardDTO);
	}

	public int reply(QnaDTO qnaDTO) throws Exception {
		QnaDTO parent = (QnaDTO) qnaDAO.getDetail(qnaDTO);
		// 1. step을 1씩 업데이트함
		int result = qnaDAO.replyUpdate(parent);

		// 2. 답글에 REF, STEP, DEPTH를 세팅
		qnaDTO.setRef(parent.getRef());
		qnaDTO.setStep(parent.getStep() + 1);
		qnaDTO.setDepth(parent.getDepth() + 1);
		return qnaDAO.reply(qnaDTO);
	}

}
