package com.jerry.app.member;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/member/*")
public class memberController {

	@Autowired
	private MemberService memberService;

	@RequestMapping(value = "joinMember", method = RequestMethod.GET)
	public void joinMember() {
		System.out.println("조인 맴버 실행됨");
	}

	@RequestMapping(value = "joinMember", method = RequestMethod.POST)
	public String joinMember(MemberDTO memberDTO, Model model, MultipartFile files, HttpSession session)
			throws Exception {

		String url = "";
		int result = memberService.joinMemberService(memberDTO, files, session);
		if (result > 0) {
			url = "redirect:/";
		} else {
			url = "commons/message";
			model.addAttribute("result", "정보 입력 실패");
			model.addAttribute("url", "./");
		}
		return url;
		// 테스트 글
	}

	@RequestMapping(value = "loginMember", method = RequestMethod.GET)
	public void loginMember(Model model,
//			HttpServletRequest request,
			@CookieValue(name = "remember", required = false, defaultValue = "") String value) {
//@CookieValue(name = "remember", required = false, defaultValue = "") String value)로 아래것들 대체함.
//		Cookie[] cookies = request.getCookies();
//		for (Cookie c : cookies) {
//			if (c.getName().equals("remember")) {
//				request.setAttribute("id", c.getValue());
//			}
//		}
		model.addAttribute("id", value);
	}

	@RequestMapping(value = "loginMember", method = RequestMethod.POST)
	public String loginMember(MemberDTO memberDTO, Model model, HttpServletResponse response, String remember,
			HttpSession session) throws Exception {

		if (remember != null) {
			Cookie cookie = new Cookie("remember", memberDTO.getUser_id());
			cookie.setMaxAge(300);
			response.addCookie(cookie);
		} else {
			Cookie cookie = new Cookie("remember", "");
			cookie.setMaxAge(0);
			response.addCookie(cookie);
		}

		memberDTO = memberService.loginMemberService(memberDTO);
		String url = "redirect:/";
		if (memberDTO != null) {
			session.setAttribute("member", memberDTO);
		} else {
			url = "commons/message";
			model.addAttribute("result", "로그인에 실패했습니다.");
			model.addAttribute("url", "/");
		}
		return url;
	}

	@RequestMapping(value = "logoutMember", method = RequestMethod.GET)
	public String logoutMember(HttpSession session) throws Exception {
		session.invalidate(); // 세션의 유지 시간을 0으로 하겠다는 뜻이다.
		// session.setAttribute("member", null); {7.5_C.1} : 이렇게 session에 있는 애를 null로
		// 맞춰서 세션을 종료 시킬 수 있다.
		// session.removeAttribute("member"); {7.5_C.1} : 로그인하고 있는 동안 데이터를 유지하기 위해선 세션을
		// 이용해야 한다.
		// session.isNew() {7.5_C.1} : 새로운 객체인지 물어보는거. 그냥 invalidate 쓰면 된다.

		return "redirect:/";
	}

	@RequestMapping(value = "myPage", method = RequestMethod.GET)
	public void myPage(HttpSession session, Model model) throws Exception {
		MemberDTO memberDTO = (MemberDTO) session.getAttribute("member");
		memberDTO = memberService.detail(memberDTO);
		model.addAttribute("member", memberDTO);
	}

	@RequestMapping(value = "update", method = RequestMethod.GET)
	public void update(HttpSession session, Model model) throws Exception {
		MemberDTO memberDTO = (MemberDTO) session.getAttribute("member");
		memberDTO = memberService.detail(memberDTO);
		model.addAttribute("member", memberDTO);

	}

	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String myPageUpdate(MemberDTO memberDTO, HttpSession session, Model model) throws Exception {
		MemberDTO dto = (MemberDTO) session.getAttribute("member");
		memberDTO.setUser_id(dto.getUser_id());
		// memberDTO.setUser_name(dto.getUser_name()) 으로 잘못 설정했다.
		int result = memberService.update(memberDTO);
		return "redirect:/member/myPage";
	}

	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String delete(MemberDTO memberDTO, HttpSession session, Model model) throws Exception {
		MemberDTO dto = (MemberDTO) session.getAttribute("member");
		memberDTO.setUser_id(dto.getUser_id());
		int result = memberService.delete(memberDTO);
		String url = "";
		if (result > 0) {
			session.invalidate();
			url = "commons/message";
			model.addAttribute("result", "회원 탈퇴 성공");
			model.addAttribute("url", "/");
		} else {
			url = "commons/message";
			model.addAttribute("result", "회원 탈퇴 실패");
			model.addAttribute("url", "./myPage");
		}
		return url;
	}

	@GetMapping("join123")
	public String join123(HttpSession session, Model model) throws Exception {
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setUser_id("123");
		memberDTO.setUser_pw("123");
		memberService.loginMemberService(memberDTO);
		memberDTO = memberService.loginMemberService(memberDTO);

		String url = "redirect:/";
		if (memberDTO != null) {
			session.setAttribute("member", memberDTO);
		} else {
			url = "commons/message";
			model.addAttribute("result", "로그인에 실패했습니다.");
			model.addAttribute("url", "/");
		}
		return url;
	}

}
