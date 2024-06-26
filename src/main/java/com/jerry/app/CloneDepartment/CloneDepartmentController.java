package com.jerry.app.CloneDepartment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("clonedepartment/*")
public class CloneDepartmentController {
	
	@Autowired
	private CloneDepartmentService cloneDepartmentService;
	
	@RequestMapping("list")
	public void getlist(Model model) throws Exception{
		List<CloneDepartmentDTO> ar = cloneDepartmentService.getlist();
		model.addAttribute("list", ar);
	}
	
	@RequestMapping("detail")
	public void detail() {
		
	}
	
	
}
