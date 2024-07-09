package com.jerry.app.account;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public void detail(AccountDTO accountDTO, Model model) throws Exception {
		accountDTO = accountService.detail(accountDTO);
		model.addAttribute("detail", accountDTO);
	}

	@RequestMapping(value = "transfer", method = RequestMethod.GET)
	public void transfer(AccountDTO accountDTO, Model model) throws Exception {
		accountDTO = accountService.detail(accountDTO);
		model.addAttribute("detail", accountDTO);
	}

	@RequestMapping(value = "transfer", method = RequestMethod.POST)
	public String transfer(AccountDTO accountDTO, TradeDTO tradeDTO, Model model) throws Exception {
		int a = accountService.transfer(accountDTO, tradeDTO);

		System.out.println(a);
		String url = "";
		Long b = tradeDTO.getAccount_num_me();
		if (a == 4) {
			url = "commons/message";
			model.addAttribute("result", "송금을 완료 하였습니다.");
			model.addAttribute("url", "./detail?account_num=" + b);
		} else {
			url = "commons/message";
			model.addAttribute("result", "잔액이 부족합니다.");
			model.addAttribute("url", "./detail?account_num=" + b);
		}
		return url;
	}

}
