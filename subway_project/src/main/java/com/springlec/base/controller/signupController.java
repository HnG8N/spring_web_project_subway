package com.springlec.base.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class signupController {
	
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

}
