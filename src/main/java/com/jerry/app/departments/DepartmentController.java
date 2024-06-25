package com.jerry.app.departments;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//컨트롤러는 service가 있어야일할 수 있음.

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
	// 어떤 유알엘이 왔을 떄 하라.
	public void getList() throws Exception {
		// 접근지정자 그외지정자 리턴타입(void)
		System.out.println("department list");
		// url 경로와 jsp 경로가 같으면 리턴을 따로 해주지 않아도 됨.
		departmentService.getList();
	}

}
