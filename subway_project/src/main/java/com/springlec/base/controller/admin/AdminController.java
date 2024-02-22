package com.springlec.base.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springlec.base.service.admin.LoginService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	LoginService service;
	
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
	
	
	
}
