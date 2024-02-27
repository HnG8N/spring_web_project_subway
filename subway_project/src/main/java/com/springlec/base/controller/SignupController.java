package com.springlec.base.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.springlec.base.service.SignupService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;


@Controller
public class SignupController {
	
	@Autowired
	SignupService service;

	@GetMapping("signup")
	public String signup() {
		return "signup/Signup";
	}

	@GetMapping("login")
	public String login() {
		return "signup/Login";
	}

	@GetMapping("findId")
	public String findId() {
		return "signup/FindId";
	}

	@GetMapping("findPw")
	public String findPw() {
		return "signup/FindPw";
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
		
		return "redirect:login";
	}
	
	@PostMapping("loginDo")
	public String loginDo(HttpServletRequest request) throws Exception{
		String mid = request.getParameter("id");
		
		HttpSession session = request.getSession();
		session.setAttribute("userId", mid);
		
		return "redirect:/";
	}
	
	@GetMapping("logout")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.invalidate();
		
		return "redirect:/";
	}
	
	@PostMapping("findIdDo")
	public String findIdDo() throws Exception{
		return "redirect:login";
	}
	
	@PostMapping("findPwDo")
	public String findPwDo() throws Exception{
		return "redirect:login";
	}
	
	
	

}
