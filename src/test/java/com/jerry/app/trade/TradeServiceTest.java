package com.jerry.app.trade;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.jerry.app.DefaultTest;
import com.jerry.app.trades.TradeService;

public class TradeServiceTest extends DefaultTest {

	@Autowired
	public TradeService tradeService;

	@Test
	public void transferTest() throws Exception {
		tradeService.trade();

		System.out.println("성공");
	}

}
