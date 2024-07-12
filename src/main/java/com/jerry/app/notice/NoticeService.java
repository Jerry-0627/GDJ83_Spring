package com.jerry.app.notice;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoticeService {

	@Autowired
	private NoticeDAO noticeDAO;

	public Map<String, Object> getList(String kind, String search) throws Exception {
		ExtraDTO extraDTO = new ExtraDTO();
		extraDTO.setKind(kind);
		extraDTO.setSearch(search);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put(("getList"), noticeDAO.getList(extraDTO));

		return map;
	}
}
