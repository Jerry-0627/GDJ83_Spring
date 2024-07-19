package com.jerry.app.member;

import java.io.File;
import java.util.Calendar;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import com.jerry.app.account.AccountDAO;

@Service
public class MemberService {

	@Autowired
	private MemberDAO memberDAO;

	@Autowired
	private AccountDAO accountDAO;

	private String name = "members";

	public int joinMemberService(MemberDTO memberDTO, MultipartFile files, HttpSession session) throws Exception {
		int result = memberDAO.joinMember(memberDTO);
		if (files == null) {
			return result;
		}

		ServletContext servletContext = session.getServletContext();
		// 1. 파일을 어디에 저장할 것인가?? 운영체제가 알고 있는 경로로 설정해줘야함.
		// 우리가 말하는 루트는 톰캣 내의.. 운영체제의 루트는 최상위 폴더. ex)C: .. 즉 경로가 다르다.
		// 내장 객체 : 톰캣이 생성하고 관리하는 객체
		String path = servletContext.getRealPath("/resources/upload/members");
		System.out.println("path 정보 : " + path);
		System.out.println("files 정보 : " + files);
		File file = new File(path);

		// 파일이 존재하냐?라는 의미 exists()
		if (!file.exists()) {
			file.mkdirs();
		}

		// 2-1. 파일명을 무엇으로 할 것인가? 무슨 이름으로 저장할 것인가? => Calendar 클래스. 시간을 이용하자.
		Calendar calendar = Calendar.getInstance();
		long n = calendar.getTimeInMillis();
		// 파일 이름에 시간을 붙이고 그 뒤엔 확장자의 정보를 넣어줘야 하는데, 이를 위해 originalfilename을 꺼내 사용한다.
		// 왜? ==
		String filename = files.getOriginalFilename();
		System.out.println("filename 1번 정보 : " + filename);
		int fileExtentionNum = filename.lastIndexOf(".");
		if (fileExtentionNum > 0) {
			String fileExtention = filename.substring(fileExtentionNum + 1);
			System.out.println("확장자 : " + fileExtention);
		}

		filename = n + "_" + files.getOriginalFilename();
		System.out.println("filename 2번 정보 : " + filename);

		// 2-2. 라이브러리를 사용하여 중복되지 않게 사용.
		filename = UUID.randomUUID().toString() + "_" + files.getOriginalFilename();
		System.out.println("filename 라이브러리 사용 정보 : " + filename);

		// 3. 파일명을 설정했으니 이것을 저장할 차례임. 하드디스크에 파일을 저장하는 단계!
		file = new File(file, filename);

		// 3-1). 라이브러리를 사용. mutipartFile
		// files.transferTo(file); 한번 전송된건 두번 전송할 수 없어서 주석처리 한 것임.

		// 3-2). 라이브러리를 사용. fileCopyUtils
		FileCopyUtils.copy(files.getBytes(), file);
		MemberFileDTO memberFileDTO = new MemberFileDTO();
		memberFileDTO.setUser_id(memberDTO.getUser_id());
		memberFileDTO.setFile_name(filename);
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
