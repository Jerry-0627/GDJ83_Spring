package com.jerry.app.boards.notice;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.jerry.app.boards.BoardDAO;
import com.jerry.app.boards.BoardDTO;
import com.jerry.app.boards.BoardFileDTO;
import com.jerry.app.files.FileManager;
import com.jerry.app.util.PageDTO;

@Service
public class NoticeService {

	@Autowired
	@Qualifier("noticeDAO")
	private BoardDAO boardDAO;

	@Autowired
	private NoticeDAO noticeDAO;

	@Autowired
	private FileManager filemanager;

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

	public int doADD(BoardDTO boardDTO, MultipartFile[] files, HttpSession session) throws Exception {
		Long num = noticeDAO.getNoticeNum();
		boardDTO.setBoard_num(num);
		int result = boardDAO.doAdd(boardDTO);

		if (files == null) {
			return result;
		}

		ServletContext servletContext = session.getServletContext();
		String path = servletContext.getRealPath("resources/upload/notice");

		for (MultipartFile f : files) {
			if (f.isEmpty()) {
				continue;
			}
			String fileNmae = filemanager.fileSave(path, f);
			System.out.println("@@@ fileName : " + fileNmae);
			BoardFileDTO boardFileDTO = new BoardFileDTO();
			boardFileDTO.setBoard_num(num);
			boardFileDTO.setFile_name(fileNmae);
			boardFileDTO.setOri_name(f.getOriginalFilename());
			result = noticeDAO.doAddFile(boardFileDTO);
			System.out.println("@@@ result : " + result);
		}

		return result;
	}
}
