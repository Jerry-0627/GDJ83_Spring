package com.jerry.app.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/product/*")
public class ProductController {
	@Autowired
	// 객체를 주입해라. ProductService 타입인
	private ProductService productService;

	@RequestMapping(value = "list", method = RequestMethod.GET)
	public void getlist(Model model) throws Exception {
		System.out.println("실행됨");
		List<ProductDTO> ar = productService.getlist();

		model.addAttribute("list", ar);

	}

	@RequestMapping(value = "detail")
	public void getdetail(Model model, ProductDTO productDTO) throws Exception {
		ProductDTO dto = productService.getdetail(productDTO);

		model.addAttribute("detail", dto);

	}

	@RequestMapping(value = "add", method = RequestMethod.GET)
	public void doadd() {
		System.out.println("add의 Get 타입");
	}

	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String doadd(ProductDTO productDTO, Model model) throws Exception {
		int result = productService.doadd(productDTO);
		String url = "";
		if (result > 0) {
			url = "./list";
		} else {
		}
		return url;
	}

}
