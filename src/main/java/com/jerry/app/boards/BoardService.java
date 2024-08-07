package com.jerry.app.boards;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;

import com.jerry.app.files.FileDTO;
import com.jerry.app.util.PageDTO;

public interface BoardService {

	// list
	public List<BoardDTO> getList(PageDTO pageDTO) throws Exception;

	// add
	public int doAdd(BoardDTO boardDTO, MultipartFile[] multipartFile, HttpSession session) throws Exception;

	// hit
	public int hitUpdate(BoardDTO boardDTO) throws Exception;

	// update
	public int doUpdate(BoardDTO boardDTO) throws Exception;

	// delete
	public int delete(BoardDTO boardDTO) throws Exception;

	public BoardDTO detail(BoardDTO boardDTO) throws Exception;

	// fileDetail
	public FileDTO fileDetail(FileDTO fileDTO) throws Exception;
}
