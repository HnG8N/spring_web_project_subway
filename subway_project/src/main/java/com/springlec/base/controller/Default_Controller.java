package com.springlec.base.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.springlec.base.model.Default_Dto;
import com.springlec.base.service.Default_Service;

@Controller
public class Default_Controller {
	
	@Autowired
	Default_Service service;
	
	@GetMapping("default_test")
	public String default_test(Model model) throws Exception {
		List<Default_Dto> defaultDtos = service.default_test();
		model.addAttribute("default_test", defaultDtos);
		return "default_test";
	}

}
