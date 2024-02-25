package com.springlec.base.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.springlec.base.model.admin.ProductCrudDto;
import com.springlec.base.service.admin.ProductCrudService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	ProductCrudService serivice;
	
	@GetMapping("/login")
	public String login() throws Exception {
		return "/admin/login";
	}
	
	@PostMapping("/logout")
	public String logout(HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		session.removeAttribute("Logged_in_ID");
		session.removeAttribute("welcome");
		return "redirect:/admin/login";
	}

	@PostMapping("/home")
	public String home() throws Exception {
		return "/admin/home";
	}
	
	@GetMapping("/salesstatus")
	public String salesstatus() throws Exception {
		return "/admin/salesstatus";
	}
	@GetMapping("/productlist")
	public String productlist() throws Exception {
		return "/admin/productlist";
	}
	@PostMapping("/productinsert")
	public String productinsertForm() throws Exception {
		return "/admin/productinsert";
	}
	// 이미지를 업로드 하면서 DB에 정보를 insert
	@PostMapping("/productinsertDB")
	public String productinsertDB(MultipartHttpServletRequest request) throws Exception {
		
		serivice.ProductInsertTask(
			request.getFile("mnimg"), request.getParameter("mnctg"), 
			request.getParameter("mnname"), request.getParameter("mnengname"), 
			request.getParameter("mninfo"), request.getParameter("mnprice"), 
			request.getParameter("mngram"), request.getParameter("mnkcal"), 
			request.getParameter("mnprotein"), request.getParameter("mnfat"), 
			request.getParameter("mnsugar"), request.getParameter("mnnatrum")
			);
		
		return "redirect:/admin/productlist";
	}
	@GetMapping("/productdetail")
	public String productdetailForm(HttpServletRequest request, Model model) throws Exception {
		ProductCrudDto dto = serivice.productDetailTask(
				Integer.parseInt(request.getParameter("mncode")));
		model.addAttribute("MENU", dto);
		return "/admin/productdetail";
	}
	@PostMapping("/productupdateDB")
	public String productdetailDB(MultipartHttpServletRequest request) throws Exception {
		
		serivice.ProductUpdateTask(
				request.getFile("mnimg"), 
				Integer.parseInt(request.getParameter("mncode")),
				request.getParameter("mnctg"), 
				request.getParameter("mnname"), request.getParameter("mnengname"), 
				request.getParameter("mninfo"), request.getParameter("mnprice"), 
				request.getParameter("mngram"), request.getParameter("mnkcal"), 
				request.getParameter("mnprotein"), request.getParameter("mnfat"), 
				request.getParameter("mnsugar"), request.getParameter("mnnatrum")
				);
		
		return "redirect:/admin/productlist";
	}
	@GetMapping("/memberinformation")
	public String memberinformation() throws Exception {
		return "/admin/memberinformation";
	}
	
	
}
