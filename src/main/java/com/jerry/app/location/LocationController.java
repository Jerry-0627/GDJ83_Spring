package com.jerry.app.location;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping(value = "/location/*")
@Controller
public class LocationController {
	@Autowired
	private LocationService locationService;

	@RequestMapping(value = "list", method = RequestMethod.GET)
	public void getList(Model model) throws Exception {
		List<LocationDTO> ar = locationService.getList();
		System.out.println(ar);
		model.addAttribute("list", ar);
	}

	@RequestMapping("detail")
	public void getDetail(Model model, int location_id) throws Exception {
		System.out.println("로케이션 디테일");
		LocationDTO dto = locationService.getDetail(location_id);
		model.addAttribute("detail", dto);

	}
}
