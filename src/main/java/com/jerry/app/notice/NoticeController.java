package com.jerry.app.notice;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/notice/*")
public class NoticeController {

	@Autowired
	private NoticeService noticeService;

	@RequestMapping(value = "list", method = RequestMethod.GET)
	public void getList(String kind, String search, Model model) throws Exception {
		Map<String, Object> map = noticeService.getList(kind, search);
		model.addAttribute("map", map);
	}

	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public void getDetail(NoticeDTO noticeDTO, Model model) throws Exception {
		model.addAttribute("doAdd", noticeService.getDetail(noticeDTO));
	}

	@RequestMapping(value = "add", method = RequestMethod.GET)
	public void doAdd() {
	}

	@RequestMapping(value = "add", method = RequestMethod.POST)
	public void doAdd(NoticeDTO noticeDTO, Model model) throws Exception {
		model.addAttribute("doAdd", noticeService.doADD(noticeDTO));
	}

}
