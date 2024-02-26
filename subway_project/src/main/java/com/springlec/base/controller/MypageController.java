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
	
	@GetMapping("mypage")
	public String MyPage(HttpServletRequest request) throws Exception{
		
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("userId");
		
		request.setAttribute("dto", service.memberDto(id));
		
		return "mypage/MyPage";
	}
	
	@GetMapping("mypagedetail")
	public String mypagedetail(HttpServletRequest request) throws Exception{
		
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("userId");
		
		request.setAttribute("dto", service.memberDto(id));
		
		return "mypage/MyPageDetail";
	}
	
	@PostMapping("deleteInfo")
	public String deleteInfo(HttpServletRequest request) throws Exception{
		
		HttpSession session = request.getSession();
		service.deleteInfo((String)session.getAttribute("userId"));
		
		session.invalidate();
		
		return "redirect:/";
	}
	
	@PostMapping("updateInfo")
	public String updateInfo(HttpServletRequest request) throws Exception{
		HttpSession session = request.getSession();
		String newpw = request.getParameter("newpw"); 
		String address = request.getParameter("address1")+" "+request.getParameter("address2"); ; 
		
		service.updateInfo((String)session.getAttribute("userId"), newpw , address);
		
		return "redirect:mypage";
	}
	
	
	

}
