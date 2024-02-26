package com.springlec.base.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.springlec.base.service.signupService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class signupController {
	
	@Autowired
	signupService service;

	@GetMapping("signup")
	public String signup() {
		return "signup/signup";
	}

	@GetMapping("login")
	public String login() {
		return "signup/login";
	}

	@GetMapping("findId")
	public String findId() {
		return "signup/findId";
	}

	@GetMapping("findPw")
	public String findPw() {
		return "signup/findPw";
	}

	@PostMapping("signupDo")
	public String signupDo(HttpServletRequest request) throws Exception {
		String mid = request.getParameter("id");
		String mpw = request.getParameter("pw");
		String mname = request.getParameter("name");
		String maddress = "(" + request.getParameter("postcode") + ") " + request.getParameter("address") + " "
				+ request.getParameter("detailAddress") + " " + request.getParameter("extraAddress");
		String mtel = request.getParameter("start") + request.getParameter("mid") + request.getParameter("end");
		String year = request.getParameter("year");
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String mbirth = year + "-" + (month.length() == 1 ? "0" + month : month) + "-"
				+ (day.length() == 1 ? "0" + day : day);
		String memail = request.getParameter("email1") + "@" + request.getParameter("email2");
		service.signup(mid, mpw, mname, maddress, mtel, mbirth, memail);
		
		return "signup/login";
	}
	
	@PostMapping("loginDo")
	public String loginDo(HttpServletRequest request) throws Exception{
		String mid = request.getParameter("id");
		
		HttpSession session = request.getSession();
		session.setAttribute("userId", mid);
		
		return "index";
	}
	
	@GetMapping("logout")
	public String logout(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		session.invalidate();
		
		return "index";
	}
	
	

}
