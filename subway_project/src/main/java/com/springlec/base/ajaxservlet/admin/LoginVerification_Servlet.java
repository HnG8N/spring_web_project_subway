package com.springlec.base.ajaxservlet.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.Gson;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet
public class LoginVerification_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Autowired
	Gson gson;
	
	public LoginVerification_Servlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	   protected void service(HttpServletRequest request, HttpServletResponse response)
			   throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");

		System.out.println("응답");
		
		List<String> list = Arrays.asList("1234", "가나다라", "abcd");
		
//		 ArrayList에 담겨 있는 데이터를 JSON으로 변경하여 전송
		PrintWriter out = response.getWriter();
		try {
			out.print(gson.toJson(list));	// Json형태로 변환
			out.flush();	// 실행 시키는 명령어
		}catch(Exception e) {
			e.printStackTrace();
		}

		
	}


}
