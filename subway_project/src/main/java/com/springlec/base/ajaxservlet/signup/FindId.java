package com.springlec.base.ajaxservlet.signup;

import java.io.IOException;
import java.io.PrintWriter;

import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.Gson;
import com.springlec.base.service.SignupService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FindId
 */
@WebServlet("/FindId")
public class FindId extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	SignupService service;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FindId() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String name = request.getParameter("name");
		String date = request.getParameter("date");
		String email = request.getParameter("email");
		
		System.out.println(name+"   "+date+"   "+email);

		int count = 0;

		try {
			count = service.checkIdInfo(name, date, email);
		} catch (Exception e) {
			e.printStackTrace();
		}

		String json = new Gson().toJson(count);
		PrintWriter out = response.getWriter();
		out.print(json);

		out.flush();
	}

}
