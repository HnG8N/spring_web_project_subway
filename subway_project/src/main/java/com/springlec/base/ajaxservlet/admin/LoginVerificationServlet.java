package com.springlec.base.ajaxservlet.admin;

import java.io.IOException;
import java.io.PrintWriter;

import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.Gson;
import com.springlec.base.model.admin.LoginVerification_Dto;
import com.springlec.base.service.admin.LoginService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(urlPatterns = "/admin/loginverification")
public class LoginVerificationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final String CONTENT_TYPE = "application/json;charset=UTF-8";
	
	@Autowired
	Gson gson;
	@Autowired
	LoginService service;
	
	public LoginVerificationServlet() {
		super();
	}
	
	@Override
	   protected void doPost(HttpServletRequest request, HttpServletResponse response)
			   throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		String mid = request.getParameter("mid");
		
		LoginVerification_Dto data = null;
		
		try {
			data = service.loginVerificationTask(mid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		session.setAttribute("Logged_in_ID", data.getMid());
		if(data.getMid() != null) {
			session.setAttribute("welcome", data.getMid() + "님 환영합니다.");
		}

//		 List에 담겨 있는 데이터를 JSON으로 변경하여 전송
		PrintWriter out = response.getWriter();
		response.setContentType(CONTENT_TYPE);
		
		try {
			out.print(gson.toJson(data));	// Json형태로 변환
			out.flush();	// 실행 시키는 명령어
		}catch(Exception e) {
			e.printStackTrace();
		}

		
	}


}
