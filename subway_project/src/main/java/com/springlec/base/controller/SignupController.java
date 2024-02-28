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
	
	// signup 화면 출력
	@GetMapping("signup")
	public String signup() {
		return "signup/Signup";
	}
	
	// login 화면 출력
	@GetMapping("login")
	public String login() {
		return "signup/Login";
	}

	// 아이디 찾기 화면 출력
	@GetMapping("findId")
	public String findId() {
		return "signup/FindId";
	}

	// 비밀번호 찾기 화면 출력
	@GetMapping("findPw")
	public String findPw() {
		return "signup/FindPw";
	}

	// 회원가입 창에서 회원가입 버튼을 눌렀을 시 작동하는 컨트롤러
	@PostMapping("signupDo")
	public String signupDo(HttpServletRequest request) throws Exception {
		// jsp에서 회원이 작성한 항목들 불러오기
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
		
		// signup 메소드를 실행. 이때 member 데이터 베이스에 회원이 작성한 정보들이 insert됨
		service.signup(mid, mpw, mname, maddress, mtel, mbirth, memail);
		
		// 완료시 다시 로그인화면으로 이동
		return "redirect:login";
	}
	
	// 로그인 시 session에 로그인 한 회원의 아이디 삽입
	@PostMapping("loginDo")
	public String loginDo(HttpServletRequest request) throws Exception{
		String mid = request.getParameter("id");
		
		HttpSession session = request.getSession();
		session.setAttribute("userId", mid);
		
		// 로그인이 됐으면 홈화면으로 이동
		return "redirect:/";
	}
	
	// 로그아웃시 session에 저장된 회원 정보를 삭제
	@GetMapping("logout")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.invalidate();
		
		// 로그아웃 됐으면 홈화면으로 이동
		return "redirect:/";
	}
	
	// 아이디 찾기가 완료되었으면 로그인 화면으로 이동
	@PostMapping("findIdDo")
	public String findIdDo() throws Exception{
		return "redirect:login";
	}
	
	//비밀번호 찾기가 완료되었으면 로그인 화면으로 이동
	@PostMapping("findPwDo")
	public String findPwDo() throws Exception{
		return "redirect:login";
	}
	
	
	

}
