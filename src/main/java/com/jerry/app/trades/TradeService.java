package com.jerry.app.trades;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TradeService {

	@Autowired
	private TradeDAO tradeDAO;

	public int trade(TradeDTO tradeDTO) throws Exception {
		// 1720516514277 계좌에서 5000원을 빼서 1720516604660에 보내기
		tradeDTO.setTrade_amount(tradeDTO.getTrade_amount() * -1);
		tradeDTO.setTrade_type("출금");

		// 거래 내역을 추가
		int result = tradeDAO.add(tradeDTO);

		// 계좌 내용을 업에이트
		result = tradeDAO.update(tradeDTO);

		// 받는 DTO 수정
		tradeDTO.setAccount_num(tradeDTO.getReceive_num());
		tradeDTO.setTrade_amount(tradeDTO.getTrade_amount() * -1);
		tradeDTO.setTrade_type("입금");

		// 받는 계좌의 거래 내역을 추가
		result = tradeDAO.add(tradeDTO);

		// 받는 계좌내용을 업데이트
		result = tradeDAO.update(tradeDTO);

		return result;
	}
}
