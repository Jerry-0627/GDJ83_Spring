package com.jerry.app.product;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.jerry.app.member.MemberDTO;
import com.jerry.app.util.CommentPageDTO;
import com.jerry.app.util.PageDTO;

@Controller
@RequestMapping("/product/*")
public class ProductController {
	@Autowired
	// 객체를 주입해라. ProductService 타입인
	private ProductService productService;

	@RequestMapping(value = "list", method = RequestMethod.GET)
	public void getlist(PageDTO pageDTO, Model model) throws Exception {
		System.out.println("실행됨");
		List<ProductDTO> list = productService.getlist(pageDTO);

		model.addAttribute("pageDTO", pageDTO);
		model.addAttribute("list", list);
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
	public String doadd(ProductDTO productDTO, Model model, MultipartFile[] attach, HttpSession session)
			throws Exception {
		int result = productService.doadd(productDTO, attach, session);
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

	@RequestMapping(value = "update", method = RequestMethod.GET)
	public String doupdate(HttpSession session, ProductDTO productDTO, Model model) throws Exception {
		MemberDTO memberDTO = (MemberDTO) session.getAttribute("member");
		String url = "";
		if (memberDTO == null) {
			url = "commons/message";
			model.addAttribute("result", "로그인한 회원만 수정이 가능합니다.");
			model.addAttribute("url", "/product/list");
		} else {
			url = "/product/update";
			model.addAttribute("update", productService.getdetail(productDTO));
		}
		return url;
	}

	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(ProductDTO productDTO, Model model) throws Exception {
		if (productService.doupdate(productDTO) > 0) {
			model.addAttribute("result", "수정을 성공했습니다.");
			model.addAttribute("url", "./list");
		} else {
			model.addAttribute("result", "수정을 실패했습니다.");
			model.addAttribute("url", "./list");
		}

		return "commons/message";
	}

	@GetMapping("addWish")
	public String addWish(Long product_num, HttpSession session, Model model) throws Exception {
		MemberDTO memberDTO = (MemberDTO) session.getAttribute("member");

		int result = productService.addWish(product_num, memberDTO.getUser_id());
		model.addAttribute("msg", result);

		return "commons/result";
	}

	@GetMapping("wishList")
	public List<ProductDTO> wishList(HttpSession session, Model model) throws Exception {
		MemberDTO memberDTO = (MemberDTO) session.getAttribute("member");
		List<ProductDTO> result = productService.wishList(memberDTO);
		model.addAttribute("list", result);

		return result;
	}

	@GetMapping("deleteWishList")
	public String deleteWishList(HttpSession session, Long[] product_num, Model model) throws Exception {
		MemberDTO memberDTO = (MemberDTO) session.getAttribute("member");
		for (Long bn : product_num) {
			System.out.println("@@ bn : " + bn);
		}
		int delResult = productService.deleteWishList(product_num, memberDTO.getUser_id());
		System.out.println(product_num);
		model.addAttribute("msg", delResult);

		return "commons/result";

	}

	@PostMapping("commentAdd")
	public String commentAdd(ProductCommentDTO pCommentDTO, HttpSession session, Model model) throws Exception {
		System.out.println("commentAdd board_num : " + pCommentDTO.getBoard_contents());
		MemberDTO memberDTO = (MemberDTO) session.getAttribute("member");

		pCommentDTO.setBoard_writer(memberDTO.getUser_id());

		int result = productService.commentAdd(pCommentDTO);

		System.out.println(result);

		model.addAttribute("msg", result);
		return "commons/result";
	}

	@GetMapping("commentList")
	public void commentList(CommentPageDTO commentPageDTO, Model model) throws Exception {
		List<ProductCommentDTO> commentlist = productService.commnetList(commentPageDTO);
		model.addAttribute("commentList", commentlist);
		model.addAttribute("pageDTO", commentPageDTO);
	}

	@PostMapping("commentDelete")
	public String commentDelete(ProductCommentDTO productCommentDTO, Model model) throws Exception {
		int result = productService.commentDelete(productCommentDTO);
		System.out.println("commentDelete : " + result);
		model.addAttribute("msg", result);
		return "commons/result";
	}

	@PostMapping("commentUpdate")
	public String commentUpdate(ProductCommentDTO productCommentDTO, Model model) throws Exception {

		int result = productService.commentUpdate(productCommentDTO);
		System.out.println("commentUpdate : " + result);
		model.addAttribute("msg", result);
		return "commons/result";
	}

	// null포인트 예외면 여기서 처리하자~ 라는 의미이다.
	@ExceptionHandler(NullPointerException.class)
	public void exceptionHandler() {

	}

	@ExceptionHandler(Exception.class)
	public void exceptionHandler2() {

	}

	// 최상위 에러 처리
	@ExceptionHandler(Throwable.class)
	public void exceptionHandler3() {

	}

}
