package com.jerry.app.member;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.jerry.app.DefaultTest;

public class MemberDAOTest extends DefaultTest {

	@Autowired
	private MemberDAO memberDAO;

	@Test
	public void loginTest() throws Exception {
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setUser_id("123");
		memberDTO = memberDAO.loginMember(memberDTO);
		assertNotNull(memberDTO);
	}

}
