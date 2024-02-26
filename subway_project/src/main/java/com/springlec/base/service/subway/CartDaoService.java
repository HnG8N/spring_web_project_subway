package com.springlec.base.service.subway;

import java.util.List;

import com.springlec.base.model.subway.CartDto;

public interface CartDaoService {
	
	// 장바구니 담기.
	public int addCart(String cmid, int cmncode, int clength, String cbread, String ctoast, String ccheese,
			String cvegetables, String csauce, int ctotprice, int cqty) throws Exception;
	
	// 장바구니에 담은 목록 보여주기.
	public List<CartDto> getMyCart(String cmid) throws Exception;
	
	// 장바구니 수량 변경.
	public int chageQty(int cqty, int cseq, String cmid) throws Exception;

}
