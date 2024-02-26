package com.springlec.base.ajaxservlet.signup;

import java.io.IOException;
import java.io.PrintWriter;

import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.Gson;
import com.springlec.base.service.signupService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/FindPw")
public class FindPw extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	signupService service;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FindPw() {
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

		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String date = request.getParameter("date");
		String email = request.getParameter("email");

		int count = 0;
		
		try {
			count = service.checkPwInfo(id, name, date, email);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String json = new Gson().toJson(count);
		PrintWriter out = response.getWriter();
		out.print(json);

		out.flush();
	}

}
