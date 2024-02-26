package com.springlec.base.service.subway;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springlec.base.dao.subway.CartDao;
import com.springlec.base.model.subway.CartDto;

@Service
public class CartDaoServiceImpl implements CartDaoService{
	@Autowired
	CartDao dao;

	// 장바구니 담기.
	@Override
	public int addCart(String cmid, int cmncode, int clength, String cbread, String ctoast, String ccheese,
			String cvegetables, String csauce, int ctotprice, int cqty) throws Exception{
		return dao.addCart(cmid, cmncode, clength, cbread, ctoast, ccheese, cvegetables, csauce, ctotprice, cqty);
	}
	
	// 장바구니에 담은 목록 보여주기.
	@Override
	public List<CartDto> getMyCart(String cmid) throws Exception{
		return dao.getMyCart(cmid);
	}
	
	// 장바구니 수량 변경.
	@Override
	public int chageQty(int cqty, int cseq, String cmid) throws Exception{
		return dao.chageQty(cqty, cseq, cmid);
	}

}
