package com.springlec.base.ajaxservlet.subway;

import java.io.IOException;
import java.io.PrintWriter;

import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.Gson;
import com.springlec.base.service.subway.OrderDaoService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class Checkout
 */
@WebServlet("/Checkout")
public class Checkout extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @Autowired
    OrderDaoService service; 
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Checkout() {
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

		String itemIdxArr[] = request.getParameterValues("itemIndexArray[]");
//		System.out.println("itemIdxArr : " + itemIdxArr.length);
		int execnt = 0, exeDelCartCnt = 0;

		for(int i=0; i<itemIdxArr.length; i++) {	 // 주문정보 orderpurchase DB에 입력. 
//			System.out.println(itemIdxArr[i]);
			execnt += service.addOrder(Integer.parseInt(itemIdxArr[i]), cmid);
		}
		if(execnt>0) {	// 입력하고 나서 장바구니에 담은 내역 삭제. 
			for(int i=0; i<itemIdxArr.length; i++) {
				exeDelCartCnt += service.deleteCartItem(Integer.parseInt(itemIdxArr[i]), cmid);
			}
		}
		// 변경되었는지 확인하고 결과를 전송.
		String json = new Gson().toJson(exeDelCartCnt);
		PrintWriter out = response.getWriter();
		out.print(json);

		out.flush();
	}

}

