package com.springlec.base.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.springlec.base.service.admin.ProductCrudService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	ProductCrudService productCrudService;
	
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
	@GetMapping("/memberinformation")
	public String memberinformation() throws Exception {
		return "/admin/memberinformation";
	}
	
	@PostMapping("/productinsert")
	public String productinsertForm() throws Exception {
		return "/admin/productinsert";
	}

	// 이미지를 업로드 하면서 DB에 정보를 insert
	@PostMapping("/productinsertDB")
	public String productinsertDB(MultipartHttpServletRequest request) throws Exception {
		MultipartFile file = request.getFile("mnimg");
		String mnctg = request.getParameter("mnctg");
		String mnname = request.getParameter("mnname");
		String mnengname = request.getParameter("mnengname");
		String mninfo = request.getParameter("mninfo");
		String mnprice = request.getParameter("mnprice");
		String mngram = request.getParameter("mngram");
		String mnkcal = request.getParameter("mnkcal");
		String mnprotein = request.getParameter("mnprotein");
		String mnfat = request.getParameter("mnfat");
		String mnsugar = request.getParameter("mnsugar");
		String mnnatrum = request.getParameter("mnnatrum");
		
		productCrudService.ProductInsertTask(file, mnctg, mnname, mnengname, mninfo, 
				mnprice, mngram, mnkcal, mnprotein, mnfat, mnsugar, mnnatrum);
		
		return "redirect:/admin/productlist";
	}
	
	
}
