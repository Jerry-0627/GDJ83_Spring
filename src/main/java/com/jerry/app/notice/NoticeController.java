package com.jerry.app.notice;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.jerry.app.member.MemberDTO;

@Controller
@RequestMapping(value = "/notice/*")
public class NoticeController {

	@Autowired
	private NoticeService noticeService;

	@RequestMapping(value = "list", method = RequestMethod.GET)
	public void getList(String kind, String search, Long page, Model model) throws Exception {
		Map<String, Object> map = noticeService.getList(kind, search, page);
		model.addAttribute("map", map);
	}
	

	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public void getDetail(NoticeDTO noticeDTO, Model model) throws Exception {
		model.addAttribute("doAdd", noticeService.getDetail(noticeDTO));
	}

	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String doAdd(HttpSession session, Model model) {
		MemberDTO memberDTO = new MemberDTO();
		memberDTO = (MemberDTO)session.getAttribute("member");
		String url = "";
		if(memberDTO == null) {
			url = "commons/message";
			model.addAttribute("result", "로그인한 회원만 글쓰기가 가능합니다.");
			model.addAttribute("url", "/notice/list");		
		}else {
			url = "/notice/add";
		}
		return url;
	}

	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String doAdd(@RequestParam(name = "board_category", required = false) String board_category, 
			@RequestParam(value = "board_title", required = false) String board_title,
			@RequestParam(value = "board_contents", required = false) String board_contents,
			HttpSession session, NoticeDTO noticeDTO, Model model) throws Exception {
		
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
		noticeDTO.setBoard_writer(memberDTO.getUser_name());
		model.addAttribute("doAdd", noticeService.doADD(noticeDTO));
		String url = "commons/message";
		
		if(board_category == null ||
				board_title == null ||
				board_title == null) {
			model.addAttribute("result", "글쓰기를 실패 하였습니다.");
			model.addAttribute("url", "/notice/add");
			return url;
		}
		
		model.addAttribute("result", "글쓰기를 성공 하였습니다.");
		model.addAttribute("url", "/notice/list");	
		return url;
	}


}
