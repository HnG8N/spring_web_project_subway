package com.springlec.base.ajaxservlet.subway;

import java.io.IOException;
import java.io.PrintWriter;

import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.Gson;
import com.springlec.base.service.subway.CartDaoService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class chageQty
 */
@WebServlet("/chageQty")
public class chageQty extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @Autowired CartDaoService service;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public chageQty() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		
		String cmid = ((String)session.getAttribute("userId")==null)? "james" : (String)session.getAttribute("userId");
		int cseq = Integer.parseInt(request.getParameter("cartIdx"));
		int qty = Integer.parseInt(request.getParameter("qty"));

		int execnt = 0;
		try {
			execnt = service.chageQty(qty, cseq, cmid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 변경되었는지 확인하고 결과를 전송.
		String json = new Gson().toJson(execnt);
		PrintWriter out = response.getWriter();
		out.print(json);

		out.flush();
	}

}
