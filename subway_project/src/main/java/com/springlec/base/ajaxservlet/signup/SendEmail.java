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

@WebServlet("/SendEmail")
public class SendEmail extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	private JavaMailSender javaMailSender; // JavaMailSender 주입

	public SendEmail() {
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		String email = request.getParameter("email");

		try {
			// 1. 메일 수신자 설정
			simpleMailMessage.setTo(email);

			// 2. 메일 제목 설정
			simpleMailMessage.setSubject("[subway] 회원가입 인증 번호 입니다.");

			// 3. 인증 번호 생성기
			StringBuffer temp = new StringBuffer();
			Random rnd = new Random();
			for (int i = 0; i < 4; i++) {
				temp.append(rnd.nextInt(10)); // 0부터 9까지의 숫자 중 하나를 랜덤하게 선택하여 추가
			}
			String authenticationKey = temp.toString();
			System.out.println("인증 번호: " + authenticationKey);

			// 4. 메일 내용 설정
			simpleMailMessage.setText("인증번호는 [ " + authenticationKey + " ] 입니다.");

			// 5. 메일 전송
			javaMailSender.send(simpleMailMessage); // JavaMailSender 인스턴스로 메일 전송
			
			//session
			HttpSession code = request.getSession();
			code.setAttribute("CODE", authenticationKey);
			
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
