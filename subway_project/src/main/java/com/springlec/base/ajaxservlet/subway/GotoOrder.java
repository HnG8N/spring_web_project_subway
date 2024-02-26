package com.springlec.base.ajaxservlet.subway;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.springlec.base.model.subway.OrderDto;
import com.springlec.base.service.subway.OrderDaoService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/GotoOrder")
public class GotoOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Autowired
	OrderDaoService service;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GotoOrder() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		
		String omid = ((String)session.getAttribute("userId")==null)? "james" : (String)session.getAttribute("userId");
		
		List<OrderDto> orderInfo = service.getMyOrder(omid);
		
	}

}
