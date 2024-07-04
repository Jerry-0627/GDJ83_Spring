package com.jerry.app.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.events.Namespace;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jerry.app.util.DBConnection;

@Repository
public class ProductDAO {

	@Autowired
	private SqlSession sqlsession;
	
	private final String NAMESPACE = "com.jerry.app.product.ProductDAO" ;


	public List<ProductDTO> getlist() throws Exception {

	}

	public ProductDTO getdetail(ProductDTO productDTO) throws Exception {

	}

	public int doadd(ProductDTO productDTO) throws Exception {

	}
}
