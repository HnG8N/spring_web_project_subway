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
 * Servlet implementation class CheckEmail
 */
@WebServlet("/CheckEmail")
public class CheckEmail extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	SignupService service;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CheckEmail() {
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
		String email = request.getParameter("email");
		response.setContentType("text/html;charset=UTF-8");
		int count = 0;

		try {
			count = service.checkEmail(email);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 회원 이메일 중복 여부를 JSON으로 변환하여 응답
		String json = new Gson().toJson(count);
		PrintWriter out = response.getWriter();
		out.print(json);

		out.flush();
	}

}
