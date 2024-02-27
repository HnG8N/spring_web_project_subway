package com.springlec.base.ajaxservlet.subway;

import java.io.IOException;
import java.io.PrintWriter;

import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.Gson;
import com.springlec.base.service.subway.OrderDaoService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetOrderNum
 */
@WebServlet("/GetOrderNum")
public class GetOrderNum extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Autowired
	OrderDaoService service;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetOrderNum() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String orderNum = "ORD"+service.getOrderNumber();
//		System.out.println("orderNum : "+orderNum);
		// 만든 오더 넘버를 전송.
		String json = new Gson().toJson(orderNum);
		PrintWriter out = response.getWriter();
		out.print(json);

		out.flush();
	}

}