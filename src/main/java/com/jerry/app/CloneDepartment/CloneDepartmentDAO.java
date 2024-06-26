package com.jerry.app.CloneDepartment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jerry.app.util.DBConnection;

@Repository
public class CloneDepartmentDAO {
	
	@Autowired
	private DBConnection dbConnection;
	
	public List<CloneDepartmentDTO> getlist() throws Exception{
		Connection con = dbConnection.getConnection();
		String sql = "SELECT *  FROM DEPARTMENTS ORDER BY DEPARTMENT_ID ASC";
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		
		ArrayList<CloneDepartmentDTO> ar = new ArrayList<CloneDepartmentDTO>();
		
		while(rs.next()) {
			CloneDepartmentDTO dto = new CloneDepartmentDTO();
			dto.setDepartment_id(rs.getInt("DEPARTMENT_ID"));
			dto.setDepartment_name(rs.getString("DEPARTMENT_NAME"));
			dto.setManager_id(rs.getLong("MANAGER_ID"));
			dto.setLocation_id(rs.getInt("LOCATION_ID"));
			ar.add(dto);
		}
		
		return ar;
	}
	
	public void detail() {
		
	}
}
