package com.jerry.app.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jerry.app.account.AccountDAO;

@Service
public class MemberService {

	@Autowired
	private MemberDAO memberDAO;

	@Autowired
	private AccountDAO accountDAO;

	public int joinMemberService(MemberDTO memberDTO) throws Exception {
		int result = memberDAO.joinMember(memberDTO);

		return result;
	}

	public MemberDTO loginMemberService(MemberDTO memberDTO) throws Exception {
		MemberDTO result = memberDAO.loginMember(memberDTO);
		if (result != null) {
			if (result.getUser_pw().equals(memberDTO.getUser_pw())) {
				// 로그인 성공지점

				return result;
			} else {
				result = null;
			}
		}

		return result;
	}

	public int update(MemberDTO memberDTO) throws Exception {
		return memberDAO.update(memberDTO);
	}

	public int delete(MemberDTO memberDTO) throws Exception {
		return memberDAO.delete(memberDTO);
	}

	public MemberDTO detail(MemberDTO memberDTO) throws Exception {
		return memberDAO.detail(memberDTO);
	}

}
