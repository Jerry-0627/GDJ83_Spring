package com.jerry.app.account;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jerry.app.member.MemberDTO;
import com.jerry.app.trades.TradeDTO;
import com.jerry.app.trades.TradeService;

@Controller
@RequestMapping("/account/*")
public class AccountController {

	@Autowired
	private AccountService accountService;

	@Autowired
	private TradeService tradeService;

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
	public void transfer() throws Exception {

	}

	@RequestMapping(value = "transfer", method = RequestMethod.POST)
	public String transfer(TradeDTO tradeDTO) throws Exception {
		// tradeDTO : 계좌번호 1개
		// 보내는 계좌 :accountNumber
		// 받는 계좌 : receiveNumber
		// tradeDTO에 receiveNumber 아래 3번째 방법으로 받을 것이다.
		// 파라미터를 받는 방법 1. httprequest로 받는 방법 2.bean 선언 3. 파라미터 이름과 동일한 데이터 타입으로 받아서
		int result = tradeService.trade(tradeDTO);

		return "redirect:/member/myPage";
	}

}
