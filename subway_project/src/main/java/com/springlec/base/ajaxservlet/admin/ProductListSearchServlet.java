package com.springlec.base.ajaxservlet.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.Gson;
import com.springlec.base.model.admin.ProductCrudDto;
import com.springlec.base.service.admin.ProductCrudService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/admin/productListSearch")
public class ProductListSearchServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
    private static final String CONTENT_TYPE = "application/json;charset=UTF-8";
	
    @Autowired
	Gson gson;
	@Autowired
	ProductCrudService service;

    public ProductListSearchServlet() {
        super();
    }

    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		System.out.println("servlet 전송");
		
		String selectSearch = request.getParameter("selectSearch");
		String search = request.getParameter("search");
		System.out.println(search + selectSearch);
		response.setContentType("text/html;charset=UTF-8");
		
		List<ProductCrudDto> dtos = null;
		try {
			dtos = service.productListSearchTask(selectSearch, search);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// List에 담겨 있는 데이터를 JSON으로 변경하여 전송
		response.setContentType(CONTENT_TYPE);
		PrintWriter out = response.getWriter();
		
		try {
			out.print(gson.toJson(dtos));	// Json형태로 변환
			out.flush();	// 실행 시키는 명령어
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

	

}
