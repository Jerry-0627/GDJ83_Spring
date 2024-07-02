package com.jerry.app.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jerry.app.util.DBConnection;

@Repository
public class ProductDAO {

	@Autowired
	private DBConnection dbConnection;

	public List<ProductDTO> getlist() throws Exception {
		Connection con = dbConnection.getConnection();
		String sql = "SELECT * FROM PRODUCT_INFO ORDER BY PRODUCT_NUM";
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		ArrayList<ProductDTO> ar = new ArrayList<ProductDTO>();

		while (rs.next()) {
			ProductDTO productDTO = new ProductDTO();
			productDTO.setProduct_Num(rs.getInt("PRODUCT_NUM"));
			productDTO.setProduct_Name(rs.getString("PRODUCT_NAME"));
			productDTO.setProduct_Rate(rs.getDouble("PRODUCT_RATE"));
			productDTO.setProduct_Ex(rs.getString("PRODUCT_EX"));
			ar.add(productDTO);
		}

		rs.close();
		st.close();
		con.close();

		return ar;
	}

	public ProductDTO getdetail(ProductDTO productDTO) throws Exception {
		Connection con = dbConnection.getConnection();
		String sql = "SELECT * FROM PRODUCT_INFO WHERE PRODUCT_NUM = ?";
		PreparedStatement st = con.prepareStatement(sql);

		st.setInt(1, productDTO.getProduct_Num());

		ResultSet rs = st.executeQuery();

		ProductDTO dto = null;
		if (rs.next()) {
			dto = new ProductDTO();
			dto.setProduct_Num(rs.getInt("PRODUCT_NUM"));
			dto.setProduct_Name(rs.getString("PRODUCT_NAME"));
			dto.setProduct_Rate(rs.getDouble("PRODUCT_RATE"));
			dto.setProduct_Ex(rs.getString("PRODUCT_EX"));
		}
		rs.close();
		st.close();
		con.close();

		return dto;

	}
}
