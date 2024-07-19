package com.jerry.app.member;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.jerry.app.DefaultTest;

public class MemberDAOTest extends DefaultTest {

	@Autowired
	private MemberDAO memberDAO;

//	@Test
//	public void loginTest() throws Exception {
//		MemberDTO memberDTO = new MemberDTO();
//		memberDTO.setUser_id("123");
//		memberDTO = memberDAO.loginMember(memberDTO);
//		assertNotNull(memberDTO);
//	}

	@Test
	public void memberFile() throws Exception {
		MemberFileDTO mFileDTO = new MemberFileDTO();
		mFileDTO.setUser_id("123");
		mFileDTO.setFile_name("asdaasd");
		mFileDTO.setOri_name("bvcbcv");

		int result = memberDAO.addFile(mFileDTO);
		System.out.println(result);

	}

}
