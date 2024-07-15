package com.jerry.app.boards.qna;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/qna/*")
public class QnaController {

	@GetMapping("list")
	public ModelAndView getList(ModelAndView mv) throws Exception {

		mv.setViewName("board/list");
		return mv;
	}

	@GetMapping("detail")
	public String getDetail() throws Exception {

		return "board/detail";
	}

	@GetMapping("add")
	public String doAdd() throws Exception {

		return "board/add";
	}

	@GetMapping("update")
	public String doUpdate() throws Exception {

		return "board/update";
	}
}
