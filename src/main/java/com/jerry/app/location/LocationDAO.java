package com.jerry.app.location;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jerry.app.util.DBConnection;

@Repository
public class LocationDAO {

	@Autowired
	private DBConnection dbconnection;

	public List<LocationDTO> getList() throws Exception {
		Connection con = dbconnection.getConnection();
		System.out.println(con);
		String sql = "SELECT * FROM LOCATIONS ORDER BY LOCATION_ID ASC";
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		ArrayList<LocationDTO> ar = new ArrayList<LocationDTO>();

		while (rs.next()) {
			LocationDTO locationDTO = new LocationDTO();
			locationDTO.setLocation_id(rs.getInt("LOCATION_ID"));
			locationDTO.setStreet_address(rs.getString("STREET_ADDRESS"));
			locationDTO.setPostal_code(rs.getString("POSTAL_CODE"));
			locationDTO.setCity(rs.getString("CITY"));
			locationDTO.setState_province(rs.getString("STATE_PROVINCE"));
			locationDTO.setCountry_id(rs.getString("COUNTRY_ID"));
			ar.add(locationDTO);
		}

		rs.close();
		st.close();
		con.close();

		return ar;
	}

	public LocationDTO getDetail(int num) throws Exception {
		Connection con = dbconnection.getConnection();
		String sql = "SELECT * FROM LOCATIONS WHERE LOCATION_ID = ?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, num);
		ResultSet rs = st.executeQuery();
		LocationDTO dto = null;
		if (rs.next()) {
			dto = new LocationDTO();
			dto.setLocation_id(rs.getInt("LOCATION_ID"));
			dto.setStreet_address(rs.getString("STREET_ADDRESS"));
			dto.setPostal_code(rs.getString("POSTAL_CODE"));
			dto.setCity(rs.getString("CITY"));
			dto.setState_province(rs.getString("STATE_PROVINCE"));
			dto.setCountry_id(rs.getString("COUNTRY_ID"));
		}

		rs.close();
		st.close();
		con.close();

		return dto;
	}

	public int add(LocationDTO locationDTO) throws Exception {

		Connection con = dbconnection.getConnection();
		String sql = "INSERT INTO LOCATIONS (LOCATION_ID, STREET_ADDRESS, POSTAL_CODE, CITY, STATE_PROVINCE, COUNTRY_ID) "
				+ " VALUES(LOCATIONS_SEQ.NEXTVAL, ?, ?, ?, ?, ?)";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, locationDTO.getStreet_address());
		st.setString(2, locationDTO.getPostal_code());
		st.setString(3, locationDTO.getCity());
		st.setString(4, locationDTO.getState_province());
		st.setString(5, locationDTO.getCountry_id());

		int result = st.executeUpdate();

		st.close();
		con.close();

		return result;

	}
}
