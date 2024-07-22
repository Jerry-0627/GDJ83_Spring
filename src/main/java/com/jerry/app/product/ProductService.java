package com.jerry.app.product;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.jerry.app.files.FileManager;
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
}
