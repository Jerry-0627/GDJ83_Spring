package com.jerry.app.member;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/member/*")
public class MemberController {

	@Autowired
	private MemberService memberService;

	@RequestMapping(value = "joinMember", method = RequestMethod.GET)
	public void joinMember() {
		System.out.println("조인 맴버 실행됨");
	}

	@RequestMapping(value = "joinMember", method = RequestMethod.POST)
	public String joinMember(MemberDTO memberDTO, Model model) throws Exception {
		int result = memberService.joinMemberService(memberDTO);
		String url = "";
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
		System.out.println(remember);

		if (remember != null) {
			Cookie cookie = new Cookie("remember", memberDTO.getUser_id());
			cookie.setMaxAge(300);
			response.addCookie(cookie);
		} else {
			Cookie cookie = new Cookie("remember", "");
			cookie.setMaxAge(0);
			response.addCookie(cookie);
		}
		System.out.println("테스트");

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
		return "redirect:/";
	}

}
