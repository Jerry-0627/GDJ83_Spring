package com.jerry.app.boards.qna;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.jerry.app.boards.BoardDTO;
import com.jerry.app.files.FileDTO;
import com.jerry.app.member.MemberDTO;
import com.jerry.app.util.PageDTO;

@Controller
@RequestMapping(value = "/qna/*")
public class QnaController {

	@Autowired
	private QnaService qnaService;

	@ModelAttribute("board")
	public String getBoard() {
		return "qna";
	}

	@GetMapping("list")
	public ModelAndView getList(PageDTO pageDTO, ModelAndView mv) throws Exception {
		List<BoardDTO> list = qnaService.getList(pageDTO);
		mv.addObject("list", list);
		mv.setViewName("board/list");
		return mv;
	}

	@GetMapping("detail")
	public String getDetail(QnaDTO qnaDTO, Model model) throws Exception {
		BoardDTO boardDTO = qnaService.detail(qnaDTO);
		boardDTO.setBoard_hit(boardDTO.getBoard_hit() + 1);
		int result = qnaService.hitUpdate(boardDTO);

		model.addAttribute("getDetail", boardDTO);
		return "board/detail";
	}

	@GetMapping("add")
	public String doAdd() throws Exception {

		return "board/add";
	}

	@PostMapping("add")
	public String doAdd(QnaDTO qnaDTO, MultipartFile[] files, HttpSession session) throws Exception {
		MemberDTO memberDTO = (MemberDTO) session.getAttribute("member");
		qnaDTO.setBoard_writer(memberDTO.getUser_id());

		int result = qnaService.doAdd(qnaDTO, files, session);
		return "redirect:./list";
	}

	@GetMapping("update")
	public String doUpdate(QnaDTO qnaDTO, Model model) throws Exception {
		BoardDTO boardDTO = qnaService.detail(qnaDTO);
		model.addAttribute("getDetail", boardDTO);
		return "board/update";
	}

	@PostMapping("update")
	public String doUpdate(BoardDTO boardDTO) throws Exception {
		int result = qnaService.doUpdate(boardDTO);
		return "redirect:./list";
	}

	@GetMapping("reply")
	public String reply(QnaDTO qnaDTO, Model model) throws Exception {
		model.addAttribute("boardDTO", qnaDTO);
		return "board/add";
	}

	@PostMapping("reply")
	public String reply(QnaDTO qnaDTO, MultipartFile[] files, HttpSession session) throws Exception {
		MemberDTO memberDTO = (MemberDTO) session.getAttribute("member");
		qnaDTO.setBoard_writer(memberDTO.getUser_id());
		int result = qnaService.reply(qnaDTO, files, session);
		return "redirect:./list";
	}

	@GetMapping("delete")
	public String delete(QnaDTO qndDTO) throws Exception {
		int result = qnaService.delete(qndDTO);
		return "redirect:./list";
	}

	@GetMapping("fileDown")
	// a태크는 뜨로우니까 getmapping이라는데.. 잘 모르겠으니 공부하자
	// 723. 아래 fileDown(FileDTO fileDTO...) 의 FileDTO 앞에 @ModelAtrribute가 생각되어 있다.
	// 723. 변수명이 fileDTO이기 떄문에 key가 fileDTO로 들어가 있다... 이 내용은 나중에 또 할거하 하심.
	public String fileDown(FileDTO fileDTO, Model model) throws Exception {
		fileDTO = qnaService.fileDetail(fileDTO);
		model.addAttribute("file", fileDTO);
		// servletContext로 인해 바로 jsp로 가지 않고 fileDown으로 가서 실해오딘다.
		// fileDown이라는 빈이 없으면.(클래스가 없으면) jsp에서 찾는다.
		return "fileDown";
	}

}
