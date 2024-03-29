package com.springlec.base.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springlec.base.model.admin.MemberInformationDto;
import com.springlec.base.service.admin.SalesStatusService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/admin")
public class AdminStatusController {
	
	@Autowired
	SalesStatusService service;
	
	@GetMapping("/salesstatus")
	public String salesstatus() throws Exception {
		return "/admin/salesstatus";
	}

	@PostMapping("/daystatus")
	public String daystatus() throws Exception {
		return "/admin/daystatus";
	}

	@PostMapping("/piestatus")
	public String piestatus() throws Exception {
		return "/admin/piestatus";
	}
	
	@GetMapping("/memberinfo")
	public String memberinfo(HttpServletRequest request, Model model) throws Exception {
		List<MemberInformationDto> dtos = service.memberInfoList(request.getParameter("userInfo"));
		model.addAttribute("MEMBER", dtos);
		return "/admin/memberinfo";
	}
	@PostMapping("/usersearch")
	public String usersearch(HttpServletRequest request, Model model) throws Exception {
		List<MemberInformationDto> dtos = service.memberInfoList(request.getParameter("userSearch"));
		model.addAttribute("MEMBER", dtos);
		return "/admin/memberinfo";
	}
	
}
