package com.jerry.app.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class loginfilter
 */
public class loginfilter implements Filter {

	/**
	 * Default constructor.
	 */
	public loginfilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// 하위 객체에서 상위 객체를 꺼낼 수 있음
		// request.getSession으로 꺼낼 수 없음. request 타입이 다름. 원래 쓰는 것은 HTTPServelt인데 지금은
		// Servlet임.
		// 따라서 부모 타입으로 형변환 해줘야힘
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();

		// 형변환 하기 싫으면 object로 받으면됨
		Object obj = session.getAttribute("member");

		if (obj != null) {
			// 다음으로 보내라는 의미
			chain.doFilter(request, response);
		} else {
			// 널이 아니면 어쨋거나 응답을 해야함. 응답을 내보내는 방식은 두가지 jsp (forward), client에 url을 보내 다시
			// 접속하게하는 redirect
			// 1. forward 방식 (여기는 스프링이 아니라 Model 이런거 못쓰고 예전에 썼던 servelt을 사용해야함
			// (2) url주소 alert 창에 메세지 보내줘야함. forward 하기 전에 request에 담아서 보내줘여ㅑ함
			request.setAttribute("result", "권한이 없습니다.");
			request.setAttribute("url", "/member/loginMember");
			// (1) 필터를 넘어가야 스프링임. 그래서 총 경로를 수동으로 다 써줘야함
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/commons/message.jsp");
			view.forward(request, response);

			// 2. redirect
//			HttpServletResponse res = (HttpServletResponse) response;
//			res.sendRedirect("/member/login");

		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
