package com.jerry.app.member;

import java.util.List;

import com.jerry.app.account.AccountDTO;

public class MemberDTO {
	private String user_id;
	private String user_name;
	private String user_phone_num;
	private String user_pw;
	private String user_email;
	private String user_address;
	private List<AccountDTO> dtos;
	private MemberFileDTO memberFileDTO;

	public MemberFileDTO getMemberFileDTO() {
		return memberFileDTO;
	}

	public void setMemberFileDTO(MemberFileDTO memberFileDTO) {
		this.memberFileDTO = memberFileDTO;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_phone_num() {
		return user_phone_num;
	}

	public void setUser_phone_num(String user_phone_num) {
		this.user_phone_num = user_phone_num;
	}

	public String getUser_pw() {
		return user_pw;
	}

	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public String getUser_address() {
		return user_address;
	}

	public void setUser_address(String user_address) {
		this.user_address = user_address;
	}

	public List<AccountDTO> getDtos() {
		return dtos;
	}

	public void setDtos(List<AccountDTO> dtos) {
		this.dtos = dtos;
	}

}
