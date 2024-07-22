package com.jerry.app.member;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.jerry.app.account.AccountDAO;
import com.jerry.app.files.FileManager;

@Service
public class MemberService {

	@Autowired
	private MemberDAO memberDAO;

	@Autowired
	private AccountDAO accountDAO;

	@Autowired
	private FileManager fileManager;

	private String name = "members";

	public int joinMemberService(MemberDTO memberDTO, MultipartFile files, HttpSession session) throws Exception {
		int result = memberDAO.joinMember(memberDTO);
		if (files == null) {
			return result;
		}

		// 1. 파일을 어디에 저장할 것인가?? 운영체제가 알고 있는 경로로 설정해줘야함.
		// 우리가 말하는 루트는 톰캣 내의.. 운영체제의 루트는 최상위 폴더. ex)C: .. 즉 경로가 다르다.
		// 내장 객체 : 톰캣이 생성하고 관리하는 객체
		ServletContext servletContext = session.getServletContext();
		String path = servletContext.getRealPath("/resources/upload/members");

		String fileName = fileManager.fileSave(path, files);

		MemberFileDTO memberFileDTO = new MemberFileDTO();
		memberFileDTO.setUser_id(memberDTO.getUser_id());
		memberFileDTO.setFile_name(fileName);
		memberFileDTO.setOri_name(files.getOriginalFilename());

		result = memberDAO.addFile(memberFileDTO);

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
