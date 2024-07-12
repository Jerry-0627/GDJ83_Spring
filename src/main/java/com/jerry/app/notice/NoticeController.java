package com.jerry.app.notice;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/notice/*")
public class NoticeController {

	@Autowired
	private NoticeService noticeService;

	@RequestMapping(value = "list")
	public void getList(String kind, String search, Model model) throws Exception {
		Map<String, Object> map = noticeService.getList(kind, search);
		model.addAttribute("map", map);
	}

	@RequestMapping(value = "add")
	public void doAdd() {

	}

}
