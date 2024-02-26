package com.springlec.base.controller.subway;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.springlec.base.model.subway.MenuDto;
import com.springlec.base.service.subway.MenuDaoService;

@Controller
public class HomeController {
	@Autowired
	MenuDaoService service;
	
	// HOME
	@GetMapping("/")
	public String home() throws Exception{
		return "index";
	}
	// 샌드위치 메뉴 목록
	@GetMapping("/sandwich")
	public String sandwich(Model model) throws Exception{
		List<MenuDto> dto = service.getMenuList("sandwich");
		model.addAttribute("MenuList",dto);
		return "productlist/sandwich";
	}
	// 샐러드 메뉴 목록
	@GetMapping("/salad")
	public String salad(Model model) throws Exception{
		List<MenuDto> dto = service.getMenuList("salad");
		model.addAttribute("MenuList",dto);
		return "productlist/salad";
	}
	// 랩,기타 메뉴 목록
	@GetMapping("/unit")
	public String unit(Model model) throws Exception{
		List<MenuDto> dto = service.getMenuList("wrap");
		model.addAttribute("MenuList",dto);
		return "productlist/unit";
	}
}
