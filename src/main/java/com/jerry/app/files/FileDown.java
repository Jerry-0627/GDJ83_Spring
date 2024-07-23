package com.jerry.app.files;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

@Component
public class FileDown extends AbstractView {
	// 723. 바로 되는 것은 아니고 view라는 클래스여야함. customview..
	// 723. 스프링이 알고 있는 메서드를 추상클래스나 인터페이스로 정의를 해둠, 이 클래스를 스플잉이 인식하기 위해 extends
	// AbstractView...을 해줌

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
//request에는 요청에 대한 모든 정보
//response는 응답에 대한 모든 정보 가 담겨 있음

		// 723.2.1
		// model에서 key를 꺼내려면 하나씩 꺼내야함그래서 iterator를 사용함, 키가 String이어서 제네릭이 String
//		Iterator<String> keys = model.keySet().iterator();
//
//		// 키가 몇개 있는지 앓 수 없으니까while
//		while (keys.hasNext()) {
//			String k = keys.next();
//			System.out.println("723. key : " + k);
//		}

		// @@@@@@@@@@@@@@@@@@@@@@@@@@@
		// 723.2.2 - 웹에서 a태그 클릭 시 파일을 업로드 했을 때의 이름으로 다운로드 하는 방법.
		// model타입이라 다 상황에 맞게 형변환 해줘야 한다.
		FileDTO fileDTO = (FileDTO) model.get("file");
		// 이름만 알면 안된다. 경로까지 알아야 한다.
		// upload 뒤에 qna가 올 수도 있고 notice도 올 수도 있고.. 하니 모든 콘트롤러가 공통적으로 사용할 수 있게 해줘야함
		String directory = (String) model.get("board");
		// 파일을 저장하거나 꺼내올 떄 운영체제를 통해서 함. 그래서 realpath를 사용한 것임
		// realpath를 구하려면 servletContext, 즉 어플리케이션 객체가 필요함. 저번엔 session에서 바로 꺼냈지만
		// override해서 request에서 꺼냄
		// 1.폴더 경로 준비
		String path = request.getSession().getServletContext().getRealPath("/resources/upload/" + directory);

		// 2. 파일 준비
		File file = new File(path, fileDTO.getFile_name());

		// 3. 응답시 인코딩 처리 (Fileter 처리 했으면 선택)
		response.setCharacterEncoding("URF-8");

		// 4. 파일의 크기 지정
		// file.length가 파일의 크기임. Long 타입이어서 강제 형변환 해줘여ㅑ함
		response.setContentLength((int) file.length());

		// 5. 다운로드 시 파일 이름 지정(업로드한 파일명 그대로 다운로드), 인코딩 설정
		// 이것들 모두 추가적인 정보임. 즉 헤더에 담기는 정보들임. 나가기 전에 담기는 정보들!
		String name = fileDTO.getOri_name();
		// 인코딩한다 name을 UTF-8로
		name = URLEncoder.encode(name, "UTF-8");

		// 6. Header 정보 설정
		// 응답 나가니까 응답에 설정해야함
		// "attachment;fileName=" 파일 명은 뭐로 할거냐? 그런 의미인듯..
		response.setHeader("Content-Disposition", "attachment;fileName=\"" + name + "\"");
		// 운반할 때 쓰는 데이터가 뭐냐? binary,즉 2진 데이터! 라는 뜻..
		response.setHeader("Content-Transfer-Encoding", "binary");

		// 7. 클라이언트에 전송
		// 하드디스크에서 파일을 읽어와서 Client로 아웃풋 하는 것.
		// FileInputStream 은 0과 1을 읽어옴
		FileInputStream fi = new FileInputStream(file);
		// 파일을 일겅와서 0과 1로 아웃풋 내보내야 함. 응답으로 나가는 스트림은 OutputStream
		OutputStream os = response.getOutputStream();
		// FileInputStream와 OutputStream를 연결 시켜줘야함.
		// 파일에서 읽어와서 카피떠서 아웃풋으로 내보내라 라는 뜻.
		FileCopyUtils.copy(fi, os);

		// 자원을 썼으면 해제해줘야함(연결된 순서의 역순으로 함)
		os.close();
		fi.close();

		System.out.println("File Down View");

	}
}
