package com.springlec.base.controller.subway;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.springlec.base.model.subway.IngredientDto;
import com.springlec.base.model.subway.MenuDto;
import com.springlec.base.service.subway.MenuDaoService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {
	@Autowired
	MenuDaoService service;
	
	// HOME
	@GetMapping("/")
	public String home() throws Exception{
		return "index";
	}
	// [footer]
	// 이용약관
	@GetMapping("/agreement")
	public String agreement() throws Exception{
		return "about/agreement";
	}
	// [footer]
	// 개인정보 처리방침
	@GetMapping("/privacy")
	public String privacy() throws Exception{
		return "about/privacy";
	}
	
	// [이용방법]
	// 써브웨이 이용방법
	@GetMapping("/utilizationSubway")
	public String utilizationSubway() throws Exception{
		return "about/utilizationSubway";
	}
	// [이용방법]
	// 신선한 재료 소개
	@GetMapping("/freshInfo")
	public String freshInfo() throws Exception{
		return "about/freshInfo";
	}
	// 
	// [이용방법]
	// 재료 영양 성분표
	@GetMapping("/freshNutritionFacts")
	public String freshNutritionFacts() throws Exception{
		return "about/freshNutritionFacts";
	}
	
	// [써브웨이]
	// 써브웨이 역사
	@GetMapping("/history")
	public String history() throws Exception{
		return "about/history";
	}
	// [써브웨이]
	// 매장찾기
	@GetMapping("/storeSearch")
	public String storeSearch() throws Exception{
		return "about/storeSearch";
	}
	
	// [온라인주문]
	// FAST-SUB
	@GetMapping("/step2")
	public String step2(HttpServletRequest request, Model model) throws Exception{
		String item = request.getParameter("item");
		List<MenuDto> dto = service.getMenuList(item);
		model.addAttribute("MenuList",dto);
		return "order/progress/step2";
	}
	
	//[온라인주문]
	// 샌드위치 메뉴 상세
	@GetMapping("/menuView")
	public String sandwichView(HttpServletRequest request, Model model) throws Exception{
		String mncode = request.getParameter("mncode");
		MenuDto dto = service.getMenuDetail(Integer.parseInt(mncode));
		model.addAttribute("dto",dto);
		return "order/progress/view";
	}

	//[온라인주문]
	// 샌드위치 메뉴 상세
	// [팝업] 원산지 정보
	@GetMapping("/origin")
	public String origin() throws Exception{
		return "ingredientNcountry/origin";
	}
	//[온라인주문]
	// 샌드위치 메뉴 상세
	// [팝업] 알레르기 정보
	@GetMapping("/allergy")
	public String allergy() throws Exception{
		return "ingredientNcountry/allergy";
	}
	//[온라인주문]
	// 랩,기타 메뉴 상세
	@GetMapping("/selectIngredient")
	public String selectIngredient(HttpServletRequest request, Model model) throws Exception{
		
		List<IngredientDto> breadDtos = service.getIngredient("bread");
		List<IngredientDto> vegitableDtos = service.getIngredient("vegetable");
		List<IngredientDto> cheeseDtos = service.getIngredient("cheese");
		List<IngredientDto> sauceDtos = service.getIngredient("sauce");
		
		model.addAttribute("breadDtos", breadDtos);
		model.addAttribute("vegitableDtos", vegitableDtos);
		model.addAttribute("cheeseDtos", cheeseDtos);
		model.addAttribute("sauceDtos", sauceDtos);
		
		HttpSession session = request.getSession();
		
		session.setAttribute("mncode", request.getParameter("mncode"));
		session.setAttribute("mnprice", request.getParameter("mnprice"));
		
		return "order/progress/selectIngredient";
	}
	//[메뉴소개]
	// 샌드위치 메뉴 목록
	@GetMapping("/sandwich")
	public String sandwich(Model model) throws Exception{
		List<MenuDto> dto = service.getMenuList("sandwich");
		model.addAttribute("MenuList",dto);
		return "productlist/sandwich";
	}
	//[메뉴소개]
	// 샐러드 메뉴 목록
	@GetMapping("/salad")
	public String salad(Model model) throws Exception{
		List<MenuDto> dto = service.getMenuList("salad");
		model.addAttribute("MenuList",dto);
		return "productlist/salad";
	}
	//[메뉴소개]
	// 랩,기타 메뉴 목록
	@GetMapping("/unit")
	public String unit(Model model) throws Exception{
		List<MenuDto> dto = service.getMenuList("wrap");
		model.addAttribute("MenuList",dto);
		return "productlist/unit";
	}
	
}