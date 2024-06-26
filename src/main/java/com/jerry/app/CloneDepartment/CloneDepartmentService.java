package com.jerry.app.CloneDepartment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CloneDepartmentService {
	@Autowired
	private CloneDepartmentDAO cloneDepartmentDAO;
	public List<CloneDepartmentDTO> getlist() throws Exception{
		return cloneDepartmentDAO.getlist();
	}
}
