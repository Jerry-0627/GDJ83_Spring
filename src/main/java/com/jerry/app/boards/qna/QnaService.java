package com.jerry.app.boards.qna;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.jerry.app.boards.BoardDTO;
import com.jerry.app.boards.BoardService;
import com.jerry.app.files.FileManager;
import com.jerry.app.util.PageDTO;

@Service
public class QnaService implements BoardService {

	@Autowired
	private QnaDAO qnaDAO;

	@Autowired
	private FileManager fileManager;

	@Override
	public List<BoardDTO> getList(PageDTO pageDTO) throws Exception {
		// 1. Row num을 계산해야 한다.
		pageDTO.makeRow();
		// 2. Page를 계산
		pageDTO.makeNum(qnaDAO.getTotalRowCount(pageDTO));
		return qnaDAO.getList(pageDTO);
	}

	@Override
	public int doAdd(BoardDTO boardDTO, MultipartFile[] multipartFiles, HttpSession session) throws Exception {
		// TODO Auto-generated method stub
		Long num = qnaDAO.getBoardNum();
		System.out.println("@@ qnaDAO.getBoardNum num : " + num);
		boardDTO.setBoard_num(num);

		int result = qnaDAO.doAdd(boardDTO);
		System.out.println("@@ qnaDAO.doAdd 실행 결과 : " + result);

		System.out.println("@@ multi : " + multipartFiles);
		if (multipartFiles == null) {
			return result;
		}
		ServletContext servletContext = session.getServletContext();
		System.out.println("@@ 서블랫 콘텍스트 : " + servletContext);

		String path = servletContext.getRealPath("resources/upload/qnas");
		System.out.println("@@ path : " + path);
		for (MultipartFile f : multipartFiles) {
			System.out.println("@@ f : " + f);
			if (f.isEmpty()) {
				System.out.println("@@ f : null");
				continue;
			}
			String fileName = fileManager.fileSave(path, f);
			System.out.println("@@ fileName : " + fileName);

			QnaFileDTO qnaFileDTO = new QnaFileDTO();
			qnaFileDTO.setBoard_num(num);
			qnaFileDTO.setFile_name(fileName);
			qnaFileDTO.setOri_name(f.getOriginalFilename());
			result = qnaDAO.doAddFile(qnaFileDTO);
			System.out.println("@@ qnaDAO.doAddFile 실행 결과 : " + result);
		}

		return result;
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
