package com.jerry.app.interceptors;

import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.jerry.app.boards.BoardDTO;
import com.jerry.app.member.MemberDTO;

public class WriterInterceptor extends HandlerInterceptorAdapter {

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		String method = request.getMethod();
		// interceptor는 get post 모두 작동하므로 post일 때는 작동하지 않게 해준 것이다.
		if (method.toUpperCase().equals("POST")) {
			return;
		}

		MemberDTO memberDTO = (MemberDTO) request.getSession().getAttribute("member");

		Map<String, Object> map = modelAndView.getModel();
		map.keySet().iterator();
		Iterator<String> it = map.keySet().iterator();

		while (it.hasNext()) {
			System.out.println("@@ WriterInterceptor");
			System.out.println(it.next());
		}

		BoardDTO boardDTO = (BoardDTO) map.get("getDetail");

		if (!boardDTO.getBoard_writer().equals(memberDTO.getUser_id())) {
//			modelAndView.setViewName("redirect:/");
			modelAndView.setViewName("commons/message");
			modelAndView.addObject("result", "작성자만 가능합니다.");
			modelAndView.addObject("url", "/");
		}
	}
}
