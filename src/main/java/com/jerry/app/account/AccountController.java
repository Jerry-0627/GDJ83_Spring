package com.jerry.app.account;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jerry.app.member.MemberDTO;

@Controller
@RequestMapping("/account/*")
public class AccountController {

	private AccountService accountService;
	
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public void account() {
	}
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public void account(AccountDTO accountDTO, HttpSession httpsession, Model model) throws Exception{
		MemberDTO memberDTO = (MemberDTO)httpsession.getAttribute("member");
		accountDTO.setUser_id(memberDTO.getUser_id());
		
		accountDTO.setBalance(0);
		
		int num = accountService.add(accountDTO);
		
		if(num>0) {
			model.addAttribute("result", "계좌 생성 완료");
			model.addAttribute("url", "/");
		}else {
			model.addAttribute("result", "계좌 생성 실패");
			model.addAttribute("url", "/");
		}
		
		
	}
}
