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
 * Servlet implementation class deleteCartItem
 */
@WebServlet("/deleteCartItem")
public class deleteCartItem extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @Autowired CartDaoService service;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteCartItem() {
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
//		int cseq = Integer.parseInt(request.getParameter("cartIdx"));
		String cartIdxArr[] = request.getParameterValues("cartIdxArr[]");
//		System.out.println(cartIdxArr.length);
		int execnt = 0;
		for(int i=0; i<cartIdxArr.length; i++) {
			try {
				execnt += service.deleteCartItem(Integer.parseInt(cartIdxArr[i]), cmid);
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// 변경되었는지 확인하고 결과를 전송.
		String json = new Gson().toJson(execnt);
		PrintWriter out = response.getWriter();
		out.print(json);

		out.flush();
	}

}
