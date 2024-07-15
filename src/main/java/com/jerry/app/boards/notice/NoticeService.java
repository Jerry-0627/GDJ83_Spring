package com.jerry.app.boards.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jerry.app.util.PageDTO;

@Service
public class NoticeService {

	@Autowired
	private NoticeDAO noticeDAO;
	private PageDTO pageDTO;

	public List<NoticeDTO> getList(PageDTO pageDTO) throws Exception {
		pageDTO.makeRow();

		long totalCount = noticeDAO.getTotalRowCount(pageDTO); // Row의 개수
		pageDTO.makeNum(totalCount);

		return noticeDAO.getList(pageDTO);
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
