package com.jerry.app.member;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jerry.app.account.AccountDAO;
import com.jerry.app.account.AccountDTO;

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

	public Map<String, Object> loginMemberService(MemberDTO memberDTO) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		MemberDTO result = memberDAO.loginMember(memberDTO);
		if (result != null) {
			if (result.getUser_pw().equals(memberDTO.getUser_pw())) {
				// 로그인 성공지점
				List<AccountDTO> ar = accountDAO.list(memberDTO);
				map.put("member", result);
				map.put("accounts", ar);
				return map;
			} else {
				result = null;
			}
		}

		return null;
	}

	public int update(MemberDTO memberDTO) throws Exception {
		return memberDAO.update(memberDTO);
	}

	public int delete(MemberDTO memberDTO) throws Exception {
		return memberDAO.delete(memberDTO);
	}
}
