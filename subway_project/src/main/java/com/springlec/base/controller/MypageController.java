package com.springlec.base.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.springlec.base.service.MyPageService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;


@Controller
public class MypageController {
	
	@Autowired
	MyPageService service;
	
	// mypage 화면 출력
	@GetMapping("mypage")
	public String MyPage(HttpServletRequest request) throws Exception{
		
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("userId");
		
		// session에 저장된 회원 아이디의 정보들을 dto라는 이름으로 jsp에 보내줌
		request.setAttribute("dto", service.memberDto(id));
		
		return "mypage/MyPage";
	}
	
	// my page detail 화면 출력
	@GetMapping("mypagedetail")
	public String mypagedetail(HttpServletRequest request) throws Exception{
		
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("userId");
		
		// session에 저장된 회원 아이디의 정보들을 dto라는 이름으로 jsp에 보내줌
		request.setAttribute("dto", service.memberDto(id));
		
		return "mypage/MyPageDetail";
	}
	
	// 회원 탈퇴시
	@PostMapping("deleteInfo")
	public String deleteInfo(HttpServletRequest request) throws Exception{
		
		HttpSession session = request.getSession();
		
		// deleteInfo 메소드로 인해 탈퇴하는 회원의 정보에 탈퇴날짜가 update됨
		service.deleteInfo((String)session.getAttribute("userId"));
		
		// 로그아웃 했을 때 처럼 session을 꺼줘야함
		session.invalidate();
		
		// 회원 탈퇴시 홈 화면으로 이동
		return "redirect:/";
	}
	
	// 회원 정보 수정 시 
	@PostMapping("updateInfo")
	public String updateInfo(HttpServletRequest request) throws Exception{
		
		HttpSession session = request.getSession();
		String newpw = request.getParameter("newpw"); 
		String address = request.getParameter("address1")+" "+request.getParameter("address2"); ; 
		
		// updateInfo 메소드로 로그인된 유저의 비밀번호와 주소를 변경
		service.updateInfo((String)session.getAttribute("userId"), newpw , address);
		
		return "redirect:mypage";
	}
	
	
	

}
