package com.jerry.app.notice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoticeService {

	@Autowired
	private NoticeDAO noticeDAO;
	

	public Map<String, Object> getList(String kind, String search, Long page) throws Exception {
		ExtraDTO extraDTO = new ExtraDTO();
		extraDTO.setKind(kind);
		extraDTO.setSearch(search);
		
		Long curPageNum = page;
		Long pageRowCount = 10L;
		Long blockPageCount = 5L;
		if(curPageNum == null) {
			curPageNum = 1L;
		}
		
		
		long pageFirstRow = (curPageNum-1)*pageRowCount + 1;
		long pageLastRow = curPageNum * pageRowCount;
		extraDTO.setPageFirstRow(pageFirstRow);
		extraDTO.setPageLastRow(pageLastRow);
		
		
		long totalRowCount = noticeDAO.getTotalRowCount(extraDTO);
		long totalPageCount = totalRowCount/pageRowCount;
			if(totalRowCount%pageRowCount != 0) {
				totalPageCount ++;
			}
		long totalBlockCount = totalPageCount/blockPageCount;
			if(totalPageCount%blockPageCount != 0) {
				totalBlockCount ++;
			}

		
				
		long curBlockNum = curPageNum/blockPageCount;
			if(curPageNum%blockPageCount != 0) {
				curBlockNum ++;
			}
		
				
		long blockFirstPageNum = (curBlockNum - 1) * blockPageCount + 1;
		long blockLastPageNum = curBlockNum * blockPageCount;
		
				
		boolean prePage = true;
		boolean nextPage = true;
			if(curBlockNum <= 1) {
				prePage = false;
			}
			if(curBlockNum == totalBlockCount) {
				nextPage = false;
				blockLastPageNum = totalPageCount;
			}	

		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("getList", noticeDAO.getList(extraDTO));
		map.put("kind", extraDTO.getKind());
		map.put("search", extraDTO.getSearch());
		map.put("curPageNum", curPageNum);
		map.put("blockFirstPageNum", blockFirstPageNum);
		map.put("blockLastPageNum", blockLastPageNum);
		map.put("prePage", prePage);
		map.put("nextPage", nextPage);
		return map;
	}

	public NoticeDTO getDetail(NoticeDTO noticeDTO) throws Exception {
		return noticeDAO.getDetail(noticeDTO);
	}
	
	public int hitUpdate(NoticeDTO noticeDTO) throws Exception{
		return noticeDAO.hitUpdate(noticeDTO);
	}
	
	public int doUpdate(NoticeDTO noticeDTO) throws Exception{
		return noticeDAO.doUpdate(noticeDTO);
	}
	
	public int doDelete(NoticeDTO noticeDTO) throws Exception{
		return noticeDAO.doDelete(noticeDTO);
	}

	public int doADD(NoticeDTO noticeDTO) throws Exception {
		return noticeDAO.doAdd(noticeDTO);
	}
}
