package com.jerry.app.trade;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.jerry.app.DefaultTest;
import com.jerry.app.trades.TradeDAO;
import com.jerry.app.trades.TradeDTO;

public class TradeDAOTest extends DefaultTest {

	@Autowired
	private TradeDAO tradeDAO;

	private TradeDTO tradeDTO;

	@BeforeClass
	public static void beforeClass() {

	}

	@Before
	public void before() {
		this.tradeDTO = new TradeDTO();
		tradeDTO.setAccount_num(1720516604660L);
		tradeDTO.setTrade_amount(5000L);
		tradeDTO.setTrade_type("입금");
	}

	@Test
	public void addTest() throws Exception {
		int result = tradeDAO.add(tradeDTO);
		assertEquals(1, result);
	}

	@Test
	public void updateTest() throws Exception {
		int result = tradeDAO.update(tradeDTO);
		assertNotEquals(0, result);
	}

	@After
	public void after() {
		tradeDTO = null;
	}

}
