package com.springlec.base.ajaxservlet.signup;

import java.io.IOException;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import com.springlec.base.service.SignupService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/SendId")
public class SendId extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Autowired
	private JavaMailSender javaMailSender; // JavaMailSender 주입

	@Autowired
	SignupService service;

	public SendId() {
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

		String name = request.getParameter("name");
		String date = request.getParameter("date");
		String email = request.getParameter("email");

		try {
			// 1. 메일 수신자 설정
			simpleMailMessage.setTo(email);

			// 2. 메일 제목 설정
			simpleMailMessage.setSubject("[subway] 회원님의 아이디 입니다.");

			// 3. 메일 내용 설정
			simpleMailMessage.setText("회원님의 아이디는 [ " + service.sendId(name, date, email) + " ] 입니다.");

			// 4. 메일 전송
			javaMailSender.send(simpleMailMessage); // JavaMailSender 인스턴스로 메일 전송

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
