package com.jerry.app.product;

import java.util.HashMap;
import java.util.Map;

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
	public void getlist(Long order, Long page, Model model) throws Exception {
		System.out.println("실행됨");
		Map<String, Object> map = new HashMap<String, Object>();
		PageDTO pageDTO = new PageDTO();
		pageDTO.setPage(page);
		pageDTO.setOrder(order);
		map = productService.getlist(pageDTO);

		model.addAttribute("map", map);
	}

	@RequestMapping(value = "detail")
	public void getdetail(Model model, ProductDTO productDTO) throws Exception {
		ProductDTO dto = productService.getdetail(productDTO);
		System.out.println(productDTO.getProduct_num());
		System.out.println(dto.getProduct_name());
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
			url = "redirect:./list";
		} else {
			url = "commons/message";
			model.addAttribute("result", "금융상품 추가 실패");
			model.addAttribute("url", "./list");
		}
		return url;
	}

	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String dodelete(ProductDTO productDTO, Model model) throws Exception {
		int result = productService.dodelete(productDTO);
		String url = "";
		if (result > 0) {
			url = "redirect:./list";
		} else {
			url = "commons/message";
			model.addAttribute("result", "삭제 실패");
			model.addAttribute("url", "./list");
		}
		return url;
	}

	@RequestMapping(value = "update")
	public String doupdate(ProductDTO productDTO, Model model) throws Exception {
		int result = productService.doupdate(productDTO);
		String url = "";
		if (result > 0) {
			url = "redirect:./list";
		} else {
			url = "commons/message";
			model.addAttribute("result", "삭제 실패");
			model.addAttribute("url", "./list");
		}
		return url;

	}

	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(ProductDTO productDTO, Model model) throws Exception {
		int result = productService.doupdate(productDTO);

		String url = "";
		if (result > 0) {
			url = "/product/update";
			model.addAttribute("update", productDTO);
		} else {
			url = "commons/message";
			model.addAttribute("result", "부서 등록에 실패했습니다.");
			model.addAttribute("url", "./list");
		}

		return url;
	}
}
