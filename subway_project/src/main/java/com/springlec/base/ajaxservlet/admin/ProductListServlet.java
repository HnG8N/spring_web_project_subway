package com.springlec.base.ajaxservlet.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.google.common.collect.Maps;
import com.google.gson.Gson;
import com.springlec.base.model.admin.ProductCrudDto;
import com.springlec.base.service.admin.ProductCrudService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/admin/productList")
public class ProductListServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
    private static final String CONTENT_TYPE = "application/json;charset=UTF-8";
    
    int listCount;
    int limit;
    int offset;
    int buttonCount;
    int buttonNum;
	
    @Autowired
	Gson gson;
	@Autowired
	ProductCrudService service;

    public ProductListServlet() {
        super();
    }

    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
    	
		buttonNum = Integer.parseInt(request.getParameter("buttonNum"));
		
		String selectSearch = request.getParameter("selectSearch");
		String search = request.getParameter("search");
		
		response.setContentType("text/html;charset=UTF-8");
		
		try {
			listCount = service.ProductListCountTask(selectSearch, search);
			limit = 5;
			buttonCount = (int)Math.ceil((double)listCount / limit);
			offset = (buttonNum-1) * limit;
		} catch (Exception e) {
			e.printStackTrace();
		}

		List<ProductCrudDto> dtos = null;
		try {
			dtos = service.productListSelectTask(selectSearch, search, limit, offset);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	    HashMap<String, Object> map = Maps.newHashMap();
		
		map.put("products", dtos);
		map.put("buttonCount", buttonCount);
		
		// List에 담겨 있는 데이터를 JSON으로 변경하여 전송
		response.setContentType(CONTENT_TYPE);
		PrintWriter out = response.getWriter();
		
		try {
			out.print(gson.toJson(map));	// Json형태로 변환
			out.flush();	// 실행 시키는 명령어
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

	

}
