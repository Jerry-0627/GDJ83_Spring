package com.jerry.app.departments;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//서비스는 DAO가 있어야 일할 수 있음. 즉 DAO에 의존적이다.

@Service
public class DepartmentService {

	@Autowired
	private DepartmentDAO departmentDAO;

	public List<DepartmentDTO> getList() throws Exception {
		return departmentDAO.getList();
	}

	public DepartmentDTO getDetail(int num) throws Exception {
		return departmentDAO.getDetail(num);
	}

	public int add(DepartmentDTO departmentDTO) throws Exception {
		return departmentDAO.add(departmentDTO);
	}

	public int delete(DepartmentDTO departmentDTO) throws Exception {
		return departmentDAO.delete(departmentDTO);
	}

	public int update(DepartmentDTO departmentDTO) throws Exception {
		return departmentDAO.update(departmentDTO);
	}
}
