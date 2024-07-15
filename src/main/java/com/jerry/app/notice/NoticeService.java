package com.jerry.app.notice;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jerry.app.util.PageDTO;

@Service
public class NoticeService {

	@Autowired
	private NoticeDAO noticeDAO;
	private PageDTO pageDTO;

	public Map<String, Object> getList(String kind, String search, Long page) throws Exception {
		if (page == null) {
			page = 1L;
		}
		if (page < 1) {
			page = 1L;
		}
		if (search == null) {
			search = "";
		}

		long perPage = 10L; // 하나의 Page에 보여줄 Row의 개수
		long startRow = (page - 1) * perPage + 1; // 첫번째 Page의 번호
		long lastRow = page * perPage; // 마지막 Page 번호

		// 하나의 Page에서 Row의 시작 값과 마지막 값 세팅
		PageDTO pageDTO = new PageDTO();
		pageDTO.setStartRow(startRow);
		pageDTO.setLastRow(lastRow);
		pageDTO.setKind(kind);
		pageDTO.setSearch(search);

		long totalCount = noticeDAO.getTotalRowCount(pageDTO); // Row의 개수

		// 찾기 쉽기 위해 키로 넣음. Map 사용 List와 페이지 개수를 Controller로 보냄
		Map<String, Object> map = pageDTO.makeNum(totalCount, perPage, page);
		map.put("list", noticeDAO.getList(pageDTO));
		map.put("kind", kind);
		map.put("search", search);

		return map;
	}

	public NoticeDTO getDetail(NoticeDTO noticeDTO) throws Exception {
		return noticeDAO.getDetail(noticeDTO);
	}

	public int hitUpdate(NoticeDTO noticeDTO) throws Exception {
		return noticeDAO.hitUpdate(noticeDTO);
	}

	public int doUpdate(NoticeDTO noticeDTO) throws Exception {
		return noticeDAO.doUpdate(noticeDTO);
	}

	public int doDelete(NoticeDTO noticeDTO) throws Exception {
		return noticeDAO.doDelete(noticeDTO);
	}

	public int doADD(NoticeDTO noticeDTO) throws Exception {
		return noticeDAO.doAdd(noticeDTO);
	}
}
