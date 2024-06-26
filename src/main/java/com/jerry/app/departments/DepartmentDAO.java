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

	public DepartmentDTO getDetail(int num) throws Exception {
		// 1. DB 접속
		Connection con = dbConnection.getConnection();

		// 2. Db 쿼리문 작성
		// 쿼리문에 문제가 있는지 파악하기 위해 쿼리문 복사해서 DBeaver에서 실행해보기
		// 원래 있던 것 : String sql = "SELECT * FROM DEPARTMENTS WHERE DEPARTMENT_ID = 90";
		// sql 인젝션을 방지하기 위해서 ? 를 넣고 4번 ? 세팅을 수행하는 것임.
		String sql = "SELECT * FROM DEPARTMENTS WHERE DEPARTMENT_ID = ?";

		// 3. 뭐키문을 보내서 미리 전송
		PreparedStatement st = con.prepareStatement(sql);

		// 4. ? 세팅.
		st.setInt(1, num);

		// 5. 최종 전송 및 결과를 처리
		ResultSet rs = st.executeQuery();

		// 6. 한 커서가 있고 내려오는 것.. while 근데 이번 쿼리문은 row의 개수가 정해져 있음. 떄문에 while을 사용하지 않아도됨.
		// 근데 조건에 맞는 row가 있을 수도 있고 없을 수도 있음

		DepartmentDTO departmentDTO = null;
		if (rs.next()) {
			departmentDTO = new DepartmentDTO();
			departmentDTO.setDepartment_id(rs.getInt("DEPARTMENT_ID"));
			departmentDTO.setDepartment_name(rs.getString("DEPARTMENT_NAME"));
			departmentDTO.setManager_id(rs.getLong("MANAGER_ID"));
			departmentDTO.setLocation_id(rs.getInt("LOCATION_ID"));
			// departmentDTO.setLocation_id(rs.getInt(4)); 이런식으로 인덱스 번호로 가져올 수도 있지만 고려해야 할
			// 것들이 많아진다.
			// 떄문에 선생님은 좀 더 명확하게 컬럼명을 쓰신다.
		}
		// 7. 연결된 순서의 역순으로 자원을 해제해야함.
		rs.close();
		st.close();
		con.close();

		return departmentDTO;
	}

	public int add(DepartmentDTO departmentDTO) throws Exception {
		// 1. DB 연결
		Connection con = dbConnection.getConnection();
		String sql = "INSERT INTO DEPARTMENTS " + " (DEPARMENT_ID, DEPARTMENT_NAME, MANAGER_ID, LOCATION_ID)"
				+ " VALUES(DEPARTMENT_SEQ.NEXTVALUE, ?, ?, ?)";

		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, departmentDTO.getDepartment_name());
		st.setLong(2, departmentDTO.getManager_id());
		st.setInt(3, departmentDTO.getLocation_id());

		// st.executeQuery() 데이터를 보내서 받아오는 것, insert는 데이터를 받아오는 것이 아님 그래서 메서드가 다름
		int result = st.executeUpdate();

		st.close();
		con.close();

		return result;
	}
}
