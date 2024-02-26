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

/**
 * Servlet implementation class CheckPw
 */
@WebServlet("/CheckPw")
public class CheckPw extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	signupService service;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CheckPw() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String mid = request.getParameter("mid");
		response.setContentType("text/html;charset=UTF-8");
		String pw = "";
		
		try {
			pw = service.checkPw(mid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String json = new Gson().toJson(pw);
		PrintWriter out = response.getWriter();
		out.print(json);

		out.flush();

	}

}
