package com.jerry.app.departments;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jerry.app.util.DBConnection;

//DAO는 DBConnection 타입에 의존적임. db커넥션 없으면 암됨
@Repository
public class DepartmentDAO {

	// DI, IOC 스프링 프레임워크에 해달라하는것
	// 어노테이션은 객체 만드는, 주입하는 어노테이션 이렇게 두 종류가 있다.
	// 주입하는 어노테이션은 일단 AutoWired가 있다

	@Autowired
	private DBConnection dbConnection;

	public List<DepartmentDTO> getList() throws Exception {
		Connection con = dbConnection.getConnection();
		System.out.println(con);

		// SQL(Query)문 작성
		// SQL 끝엔 원래 ; 붙였는데 자바에선느 안씀
		String sql = "SELECT * FROM DEPARTMENTS ORDER BY DEPARTMENT_ID ASC";

		// 작성한 쿼리문을 미리 전송하는 역할
		PreparedStatement st = con.prepareStatement(sql);

		// ? 값은 세팅하는 단계

		// 최종 전송 및 결과 처리
		// st.executeQuery()가 최종 전송이고 결과는 rs에 담겠다는 것
		ResultSet rs = st.executeQuery();

		ArrayList<DepartmentDTO> ar = new ArrayList<DepartmentDTO>();

		while (rs.next()) {
			DepartmentDTO departmentDTO = new DepartmentDTO();
			int id = rs.getInt("DEPARTMENT_ID");
			String name = rs.getString("DEPARTMENT_NAME");

			departmentDTO.setDepartment_id(id);
			departmentDTO.setDepartment_name(name);
			departmentDTO.setManager_id(rs.getLong("MANAGER_ID"));
			departmentDTO.setLocation_id(rs.getInt("LOCATION_ID"));
			ar.add(departmentDTO);
		}

		// 끝났으면 자원 해제 (db랑 연결되어 있으니꼐)
		rs.close();
		st.close();
		con.close();

		// 데이터를 return 해줘야 하는데 그거 때문에 DTO가 필요하다
		return ar;
	}
}
