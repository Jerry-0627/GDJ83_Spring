package com.jerry.app.departments;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/department/*")
public class DepartmentController {

	// IOC : Inversion Of Controll
	// 어노테이션 (설명과 실행의 의미가 있음)
	// 자바에서 주로 하는 일은 객체를 생성하고 매서드를 호출함
	// 객체를 생성해야 하는데 우리가 직접하지 않고 객체를 생성하는 어노테이션이 있다.
	// Controller, Service, Repository, Component(앞에 세 가지가 아닌 다른 것 만들고 싶을 떄 사용함)
	// 등이있다.

	@Autowired
	private DepartmentService departmentService;

	@RequestMapping(value = "list", method = RequestMethod.GET)
	// 위에 @RequestMapping(value = "list", method = RequestMethod.GET) 에서 method는
	// 기본적으로 get 메소드이기 떄문에
	// @RequestMapping("list")와 같이 써도 옳다.
	// 어떤 유알엘이 왔을 떄 하라.

// 방법 1
	public void getList(Model model) throws Exception {
		// 접근지정자 그외지정자 리턴타입(void)
		System.out.println("department list");
		// url 경로와 jsp 경로가 같으면 리턴을 따로 해주지 않아도 됨.
		List<DepartmentDTO> ar = departmentService.getList();

		// request와 비슷한 역할을 함.
		model.addAttribute("list", ar);
	}

//	방법 2
//	public ModelAndView getList() throws Exception {
//		// 접근지정자 그외지정자 리턴타입(void)
//		System.out.println("department list");
//		// url 경로와 jsp 경로가 같으면 리턴을 따로 해주지 않아도 됨.
//		List<DepartmentDTO> ar = departmentService.getList();
//		// Model+ View
//		ModelAndView mv = new ModelAndView();
//		// setAttribute와 같은거임
//		mv.addObject("list", ar);
//		return mv;

//	방법 3
//	public String getList() throws Exception {
//		// 접근지정자 그외지정자 리턴타입(void)
//		System.out.println("department list");
//		List<DepartmentDTO> ar = departmentService.getList();
//		// Model+ View
//		ModelAndView mv = new ModelAndView();
//		mv.setViewName("department/list");
//		return mv;

	@RequestMapping("detail")
	// @RequestParam(name = "num") int department_id 파라미터 이름이 num이 들어오면 num으로 들어온 값을
	// int department_id 를 넣어라.
	// 파라미터의 이름과 컨트롤에 선언된 이름이 일치하지 않은 경우 이런 식으로 매칭해줌.
	// defaultValue를 통해 기본값을 정할 수 있다.
//	public void getDetail(Model model, @RequestParam(name = "num", defaultValue = "10") int department_id)
//			throws Exception {
// 	없는 department_id가 왔을 떄 message로 가려면 리턴 타입을 void로 하면 안됨.
	public String getDetail(Model model, int department_id) throws Exception {
		System.out.println("Detail 실행됨.");
		DepartmentDTO departmentDTO = departmentService.getDetail(department_id);
		String path = "commons/message";
		if (departmentDTO != null) {
			model.addAttribute("dto", departmentDTO);
			path = "department/detail";
		} else {
			model.addAttribute("result", "부서를 찾을수가 없다.");
//			path = "commons/message";
			model.addAttribute("url", "./list");
		}
		return path;
	}

	@RequestMapping(value = "add", method = RequestMethod.GET)
	public void add() {
		System.out.println("애드 get");
	}

	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String add(DepartmentDTO departmentDTO, Model model) throws Exception {
		int result = departmentService.add(departmentDTO);
		String url = "";
		if (result > 0) {
			url = "redirect:./list";
		} else {
			url = "commons/message";
			model.addAttribute("result", "부서 등록에 실패");
			model.addAttribute("url", "./list");
		}
		return url;
	}

	@RequestMapping("delete")
	public String delete(DepartmentDTO departmentDTO, Model model) throws Exception {
		System.out.println("삭제");
		int result = departmentService.delete(departmentDTO);
		String url = "";
		if (result > 0) {
			url = "redirect:./list";
		} else {
			url = "commons/message";
			model.addAttribute("result", "삭제 실패");
			model.addAttribute("url", "./list");
		}
		return url;
	}

	@RequestMapping("update")
	public String update(int department_id, Model model) throws Exception {
		DepartmentDTO departmentDTO = departmentService.getDetail(department_id);
		String url = "commons/message";
		if (departmentDTO != null) {
			System.out.println("실행됨");
			model.addAttribute("update", departmentDTO);
			url = "department/update";
		} else {
			System.out.println("실행 안됨");
			model.addAttribute("result", "없는 부서");
			model.addAttribute("url", "list");
		}
		return url;
	}

	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(DepartmentDTO departmentDTO) throws Exception {
		System.out.println("아아아!");
		int result = departmentService.update(departmentDTO);
		return "redirect:list";
	}
}
