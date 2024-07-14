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
		NoticeDTO detailNoticeDTO =  noticeService.getDetail(noticeDTO);
		long viewHit = detailNoticeDTO.getBoard_hit();
		viewHit++;
		detailNoticeDTO.setBoard_hit(viewHit);
		int a = noticeService.hitUpdate(detailNoticeDTO);
		System.out.println("성공 여부 : " + a);
		model.addAttribute("getDetail", detailNoticeDTO);
	}
	
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public String doUpdate(HttpSession session , NoticeDTO noticeDTO, Model model) throws Exception {
		MemberDTO sessionMemberDTO = (MemberDTO)session.getAttribute("member");
		NoticeDTO detailNoticeDTO = noticeService.getDetail(noticeDTO);
			System.out.println("업데이트 갯 : " + detailNoticeDTO.getBoard_contents());
		String url = "commons/message";
		if(sessionMemberDTO == null) {
			model.addAttribute("result", "로그인한 회원만 수정이 가능합니다.");
			model.addAttribute("url", "/member/loginMember");		
		}else if(!detailNoticeDTO.getBoard_writer().equals(sessionMemberDTO.getUser_id())) {
			model.addAttribute("result", "본인의 글만 수정이 가능합니다.");
			model.addAttribute("url", "/notice/list");		
		}else{
			url = "/notice/update";
			model.addAttribute("getDetail", noticeService.getDetail(noticeDTO));
		}
		return url;
	}
	
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String doUpdate(NoticeDTO noticeDTO, Model model) throws Exception{
		int result = noticeService.doUpdate(noticeDTO);
		System.out.println("업데이트 포스트 : " + result);
		if(result>0) {
			model.addAttribute("result", "수정을 성공하였습니다.");
			model.addAttribute("url", "/notice/list");
		}else {
			model.addAttribute("result", "수정을 실패하였습니다.");
			model.addAttribute("url", "/notice/list");
		}
		return "commons/message";
	}

	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String doDelete(HttpSession session ,NoticeDTO noticeDTO, Model model) throws Exception{
		MemberDTO sessionMemberDTO = (MemberDTO)session.getAttribute("member");
		NoticeDTO detailNoticeDTO = noticeService.getDetail(noticeDTO);
		String url = "commons/message";
		if(sessionMemberDTO == null) {
			model.addAttribute("result", "로그인한 회원만 삭제가 가능합니다.");
			model.addAttribute("url", "/member/loginMember");		
		}else if(!detailNoticeDTO.getBoard_writer().equals(sessionMemberDTO.getUser_id())) {
			model.addAttribute("result", "본인의 글만 삭제가 가능합니다.");
			model.addAttribute("url", "/notice/list");		
		}else{
			noticeService.doDelete(detailNoticeDTO);
			model.addAttribute("result", "삭제를 성공하였습니다.");
			model.addAttribute("url", "/notice/list");
		}
		return url;
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
