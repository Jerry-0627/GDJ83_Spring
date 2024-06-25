package com.jerry.app.departments;

public class DepartmentDTO {
	// 사용하려는 테이블의 컬럼명과 타입을 일치 시키면 된다.
	// 오라클에서 대문자로 시작해도 괜찮았는데, 자바의 문법에서는 소문자로 시작해야함
	private Integer department_id;
	private String department_name;
	private Long manager_id;
	private Integer location_id;

	public Integer getDepartment_id() {
		return department_id;
	}

	public void setDepartment_id(Integer department_id) {
		this.department_id = department_id;
	}

	public String getDepartment_name() {
		return department_name;
	}

	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
	}

	public Long getManager_id() {
		return manager_id;
	}

	public void setManager_id(Long manager_id) {
		this.manager_id = manager_id;
	}

	public Integer getLocation_id() {
		return location_id;
	}

	public void setLocation_id(Integer location_id) {
		this.location_id = location_id;
	}

}
