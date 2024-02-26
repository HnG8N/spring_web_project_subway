package com.springlec.base.ajaxservlet.signup;

import java.io.IOException;
import java.io.PrintWriter;
import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class EmailCheckCode
 */
@WebServlet("/EmailCheckCode")
public class EmailCheckCode extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EmailCheckCode() {
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

		HttpSession session = request.getSession();
		String code = (String) session.getAttribute("CODE");
		String emailcode = request.getParameter("emailcode");
		String result = "";

		if (code.equals(emailcode)) {
			result = "true";
		} else {
			result = "false";
		}

		response.setContentType("text/html;charset=UTF-8");

		String json = new Gson().toJson(result);
		PrintWriter out = response.getWriter();
		out.print(json);

		out.flush();

	}

}
