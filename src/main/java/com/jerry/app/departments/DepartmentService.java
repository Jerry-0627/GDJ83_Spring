package com.jerry.app.departments;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//서비스는 DAO가 있어야 일할 수 있음. 즉 DAO에 의존적이다.

@Service
public class DepartmentService {

	@Autowired
	private DepartmentDAO departmentDAO;

	public void getList() throws Exception {
		departmentDAO.getList();
	}
}
