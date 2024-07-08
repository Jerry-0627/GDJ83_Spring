package com.jerry.app.account;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jerry.app.member.MemberDTO;

@Controller
@RequestMapping("/account/*")
public class AccountController {

	@Autowired
	private AccountService accountService;

	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String account(AccountDTO accountDTO, HttpSession session) throws Exception {
		// product_id를 받아와야함. 그래서 파마리터를 넘겨줘야함.
		String name = ((MemberDTO) session.getAttribute("member")).getUser_id();
		accountDTO.setUser_id(name);

		int result = accountService.add(accountDTO);

		return "redirect:/";

	}

}
