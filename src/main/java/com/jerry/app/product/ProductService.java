package com.jerry.app.product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.jerry.app.files.FileManager;
import com.jerry.app.member.MemberDTO;
import com.jerry.app.util.PageDTO;

@Service
public class ProductService {
	@Autowired
	// DAO가 필요ㅐ서
	private ProductDAO productDAO;

	@Autowired
	private FileManager fileManager;

	private PageDTO pageDTO;

	public List<ProductDTO> getlist(PageDTO pageDTO) throws Exception {
		pageDTO.makeRow();

		long totalCount = productDAO.getnum(pageDTO);

		pageDTO.makeNum(totalCount);

		return productDAO.getlist(pageDTO);
	}

	public ProductDTO getdetail(ProductDTO productDTO) throws Exception {
		ProductDTO dto = productDAO.getdetail(productDTO);

		return dto;
	}

	public int doadd(ProductDTO productDTO, MultipartFile[] files, HttpSession session) throws Exception {
		Long num = productDAO.getproductnum();
		productDTO.setProduct_num(num);

		int result = productDAO.doadd(productDTO);

		if (files == null) {
			return result;
		}
		// 1. 저장할 폴더 지정
		// resources/upload/product
		ServletContext servletContext = session.getServletContext();
		String path = servletContext.getRealPath("resources/upload/products");
		System.out.println("@product : " + path);
		// 2. 저장할 파일명 생성
		for (MultipartFile f : files) {
			if (f.isEmpty()) {
				continue;
			}
			String fileName = fileManager.fileSave(path, f);

			// 4. 파일 정보를 DB에 저장
			// 파일명, 오리지널 이름, 파일번호, 제품ID,
			ProductFileDTO productFileDTO = new ProductFileDTO();
			productFileDTO.setFile_name(fileName);
			productFileDTO.setOri_name(f.getOriginalFilename());
			productFileDTO.setProduct_num(num);
			result = productDAO.doaddfile(productFileDTO);
		}

		return result;
	}

	public int dodelete(ProductDTO productDTO) throws Exception {
		int result = productDAO.dodelete(productDTO);
		return result;
	}

	public int doupdate(ProductDTO productDTO) throws Exception {
		int result = productDAO.doupdate(productDTO);
		return result;
	}

	public int addWish(Long product_num, String id) throws Exception {
		// product_num과 id를 하나로 합쳐서 dao로 보내줘야 함
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("product_num", product_num);
		map.put("user_id", id);
		int result = productDAO.addWish(map);
		return result;
	}

	public List<ProductDTO> wishList(MemberDTO memberDTO) throws Exception {
		return productDAO.wishList(memberDTO);
	}

	public int deleteWishList(Long[] product_num, String user_id) throws Exception {
		int result = 0;
		for (Long bn : product_num) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("product_num", bn);
			map.put("user_id", user_id);
			result = productDAO.deleteWishList(map);
		}

		return result;

	}

}
