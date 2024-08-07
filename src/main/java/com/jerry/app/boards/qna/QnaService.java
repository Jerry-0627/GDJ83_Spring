package com.jerry.app.boards.qna;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.jerry.app.boards.BoardDTO;
import com.jerry.app.boards.BoardFileDTO;
import com.jerry.app.boards.BoardService;
import com.jerry.app.files.FileDTO;
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
		boardDTO.setBoard_num(num);

		int result = qnaDAO.doAdd(boardDTO);

		if (multipartFiles == null) {
			return result;
		}
		ServletContext servletContext = session.getServletContext();

		String path = servletContext.getRealPath("resources/upload/qna");
		for (MultipartFile f : multipartFiles) {
			if (f.isEmpty()) {
				continue;
			}
			String fileName = fileManager.fileSave(path, f);

			BoardFileDTO boardFileDTO = new BoardFileDTO();
			boardFileDTO.setBoard_num(num);
			boardFileDTO.setFile_name(fileName);
			boardFileDTO.setOri_name(f.getOriginalFilename());
			result = qnaDAO.doAddFile(boardFileDTO);
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

	public int reply(QnaDTO qnaDTO, MultipartFile[] multipartFiles, HttpSession session) throws Exception {
		QnaDTO parent = (QnaDTO) qnaDAO.getDetail(qnaDTO);
		System.out.println("@@@@ parent.getRef : " + parent.getRef());
		// 1. step을 1씩 업데이트함
		int result = qnaDAO.replyUpdate(parent);
		System.out.println("실행은됨2");

		// 2. 답글에 REF, STEP, DEPTH를 세팅
		qnaDTO.setRef(parent.getRef());
		qnaDTO.setStep(parent.getStep() + 1);
		qnaDTO.setDepth(parent.getDepth() + 1);
		result = qnaDAO.reply(qnaDTO);

		// 파일 저장
		String path = session.getServletContext().getRealPath("resources/upload/qna");

		if (multipartFiles == null) {
			return result;
		}

		for (MultipartFile f : multipartFiles) {
			if (f.isEmpty()) {
				continue;
			}
			String fileName = fileManager.fileSave(path, f);
			BoardFileDTO boardFileDTO = new BoardFileDTO();

			boardFileDTO.setBoard_num(qnaDTO.getBoard_num());
			boardFileDTO.setFile_name(fileName);
			boardFileDTO.setOri_name(f.getOriginalFilename());
			result = qnaDAO.doAddFile(boardFileDTO);

		}
		return result;
	}

	@Override
	public FileDTO fileDetail(FileDTO fileDTO) throws Exception {
		// TODO Auto-generated method stub
		return qnaDAO.fileDetail(fileDTO);
	}

}
