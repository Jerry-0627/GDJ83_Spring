package com.jerry.app.boards.notice;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jerry.app.member.MemberDTO;
import com.jerry.app.util.PageDTO;

@Controller
@RequestMapping(value = "/notice/*")
public class NoticeController {

	@Autowired
	private NoticeService noticeService;

	@RequestMapping(value = "list", method = RequestMethod.GET)
	public void getList(PageDTO pageDTO, Model model) throws Exception {
		List<NoticeDTO> list = noticeService.getList(pageDTO);
		model.addAttribute("pageDTO", pageDTO);
		model.addAttribute("list", list);
	}

	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public void getDetail(NoticeDTO noticeDTO, Model model) throws Exception {
		NoticeDTO detailNoticeDTO = noticeService.getDetail(noticeDTO);
		detailNoticeDTO.setBoard_hit(detailNoticeDTO.getBoard_hit() + 1);
		int hitUpdate = noticeService.hitUpdate(detailNoticeDTO);
		model.addAttribute("getDetail", detailNoticeDTO);
	}

	@RequestMapping(value = "update", method = RequestMethod.GET)
	public String doUpdate(HttpSession session, NoticeDTO noticeDTO, Model model) throws Exception {
		MemberDTO sessionMemberDTO = (MemberDTO) session.getAttribute("member");
		NoticeDTO detailNoticeDTO = noticeService.getDetail(noticeDTO);
		System.out.println("Update Get : " + detailNoticeDTO.getBoard_contents());
		String url = "commons/message";
		if (sessionMemberDTO == null) {
			model.addAttribute("result", "로그인한 회원만 수정이 가능합니다.");
			model.addAttribute("url", "/member/loginMember");
		} else if (!detailNoticeDTO.getBoard_writer().equals(sessionMemberDTO.getUser_id())) {
			model.addAttribute("result", "본인의 글만 수정이 가능합니다.");
			model.addAttribute("url", "/notice/list");
		} else {
			url = "/notice/update";
			model.addAttribute("getDetail", detailNoticeDTO);
			System.out.println("제목 : " + detailNoticeDTO.getBoard_title());
			System.out.println("내용 : " + detailNoticeDTO.getBoard_contents());
			System.out.println("작성자 : " + detailNoticeDTO.getBoard_writer());
			System.out.println("카테고리 : " + detailNoticeDTO.getBoard_category());
			System.out.println("조회수 : " + detailNoticeDTO.getBoard_hit());
			System.out.println("생성일 : " + detailNoticeDTO.getCreate_date());
			System.out.println("수정일 : " + detailNoticeDTO.getUpdate_date());
		}
		return url;
	}

	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String doUpdate(NoticeDTO noticeDTO, Model model) throws Exception {
		if (noticeService.doUpdate(noticeDTO) > 0) {
			model.addAttribute("result", "수정을 성공하였습니다.");
			model.addAttribute("url", "./list");
		} else {
			model.addAttribute("result", "수정을 실패하였습니다.");
			model.addAttribute("url", "./list");
		}
		return "commons/message";
	}

	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String doDelete(HttpSession session, NoticeDTO noticeDTO, Model model) throws Exception {
		MemberDTO sessionMemberDTO = (MemberDTO) session.getAttribute("member");
		NoticeDTO detailNoticeDTO = noticeService.getDetail(noticeDTO);
		String url = "commons/message";
		if (sessionMemberDTO == null) {
			model.addAttribute("result", "로그인한 회원만 삭제가 가능합니다.");
			model.addAttribute("url", "/member/loginMember");
		} else if (!detailNoticeDTO.getBoard_writer().equals(sessionMemberDTO.getUser_id())) {
			model.addAttribute("result", "본인의 글만 삭제가 가능합니다.");
			model.addAttribute("url", "/notice/list");
		} else {
			noticeService.doDelete(detailNoticeDTO);
			model.addAttribute("result", "삭제를 성공하였습니다.");
			model.addAttribute("url", "/notice/list");
		}
		return url;
	}

	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String doAdd(HttpSession session, Model model) {
		MemberDTO memberDTO = (MemberDTO) session.getAttribute("member");
		String url = "";
		if (memberDTO == null) {
			url = "commons/message";
			model.addAttribute("result", "로그인한 회원만 글쓰기가 가능합니다.");
			model.addAttribute("url", "/notice/list");
		} else {
			url = "/notice/add";
		}
		return url;
	}

	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String doAdd(HttpSession session, NoticeDTO noticeDTO, Model model) throws Exception {

		MemberDTO memberDTO = (MemberDTO) session.getAttribute("member");
		noticeDTO.setBoard_writer(memberDTO.getUser_id());
		model.addAttribute("doAdd", noticeService.doADD(noticeDTO));
		String url = "commons/message";

		/*
		 * @RequestParam(name = "board_category", required = false) String
		 * board_category,
		 * 
		 * @RequestParam(value = "board_title", required = false) String board_title,
		 * 
		 * @RequestParam(value = "board_contents", required = false) String
		 * board_contents, if (board_category == null || board_title == null ||
		 * board_title == null) { model.addAttribute("result", "글쓰기를 실패 하였습니다.");
		 * model.addAttribute("url", "/notice/add"); return url; }
		 */
		model.addAttribute("result", "글쓰기를 성공 하였습니다.");
		model.addAttribute("url", "/notice/list");
		return url;
	}

}
