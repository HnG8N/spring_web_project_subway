package com.springlec.base.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminStatusController {
	
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

}
