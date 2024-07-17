package com.jerry.app;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(HttpServletRequest request) {
		System.out.println("@@ master @@");
//		Cookie[] cookies = request.getCookies();
//		for (Cookie c : cookies) {
//			System.out.println(c.getName());
//			System.out.println(c.getValue());
//		}
//
//		Cookie cookie = new Cookie("test", "LJM");
//		cookie.setMaxAge(60);
//		// 클라이언트 컴퓨터에 몇초간 저장할지 설정하는것이 cookie.setMaxAge(?)
//		response.addCookie(cookie);

		// 하위 내장 객체에서 상위 내장 객체를 꺼낼 순 있는데 역은 안됨.
		// 상 : 서블릿컨테스트 리퀘스트 페이지
		// 하 :
		HttpSession session = request.getSession();
		session.getServletContext();
		return "index";
	}

}
