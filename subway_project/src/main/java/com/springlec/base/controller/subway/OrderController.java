package com.springlec.base.controller.subway;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.springlec.base.dao.subway.OrderDao;
import com.springlec.base.model.subway.CartDto;
import com.springlec.base.model.subway.OrderDto;
import com.springlec.base.service.subway.OrderDaoService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class OrderController {
	@Autowired
	OrderDaoService service;

	@GetMapping("confirmOrder")
	public String confirmOrder(HttpServletRequest request, Model model) throws Exception{
		String ordNo = request.getParameter("ordNo");
		HttpSession session = request.getSession();
		
		String mid = ((String)session.getAttribute("userId")==null)? "james" : (String)session.getAttribute("userId");
		
		List<OrderDto> orderInfo = service.getMyOrder(mid);
		String memberTelno = service.getTelNo(mid);
		
		model.addAttribute("ordNo", ordNo);
		model.addAttribute("orderInfo", orderInfo);
		model.addAttribute("memberTelno", memberTelno);
		
		return "order/progress/bill/confirmOrder";
	}
	
}
