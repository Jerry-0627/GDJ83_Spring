package com.jerry.app.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

	@Autowired
	private MemberDAO memberDAO;

	public int joinMemberService(MemberDTO memberDTO) throws Exception {
		int result = memberDAO.joinMember(memberDTO);

		return result;
	}

	public MemberDTO loginMemberService(MemberDTO memberDTO) throws Exception {
		MemberDTO result = memberDAO.loginMember(memberDTO);
		if (result != null) {
			if (result.getUser_pw().equals(memberDTO.getUser_pw())) {
				return result;
			} else {
				return null;
			}
		}

		return result;
	}

}
