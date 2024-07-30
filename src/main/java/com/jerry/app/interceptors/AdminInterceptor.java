package com.jerry.app.interceptors;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.jerry.app.member.MemberDTO;

public class AdminInterceptor extends HandlerInterceptorAdapter {

	// 언제 검사를 할 것인지 체크하기 (들어갈 때 검사하려면 prehandle
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		MemberDTO memberDTO = (MemberDTO) request.getSession().getAttribute("member");
		System.out.println("AdminInterceptor");

		// TODO Auto-generated method stub
		// 로그인 안하고 주소를 치고 들어올 수 있기 때문에 아래 if절을 하는 것.
		// 만약 필터를 넣었으면 괜찮을 수 있음.
		if (memberDTO == null) {
			// redirect로 보내는 방식
			response.sendRedirect("/member/loginMember");
			// 다음으로 넘어가지 못하게 false
			return false;
		}
		// 관리자 계정이면 ~~
		if (!memberDTO.getUser_id().equals("123")) {
			// forward로 보내는 방식
			// 권한이 없다는 메세지를 띄우기 위해 jsp의 message로 보내야함.
			// model이 없기 때문에 request로 보냄
			System.out.println("123이 아닐 떄 실행됨");
			request.setAttribute("result", "권한이 없습니다.");
			request.setAttribute("url", "/");
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/commons/message.jsp");
			view.forward(request, response);

			return false;
		}

		// 관리자가 아니면 어디로 갈 것인지도 설정해야 함.
		// 응답을 내보내는 방법 forward, redirect
		return true;
	}
}
