package com.springlec.base.service.subway;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springlec.base.dao.subway.OrderDao;
import com.springlec.base.model.subway.OrderDto;

@Service
public class OrderDaoServiceImpl implements OrderDaoService {
	@Autowired
	OrderDao dao;

	@Override
	public int addOrder(int cseq, String cmid) {
		// TODO Auto-generated method stub
		return dao.addOrder(cseq, cmid);
	}
	
	public int deleteCartItem(int cseq, String cmid) {
		
		return dao.deleteCartItem(cseq, cmid);
	}
	public String getOrderNumber() {
		return dao.getOrderNumber();
		
	}
	public List<OrderDto> getMyOrder(String mid){
		return dao.getMyOrder(mid);
	}
	public String getTelNo(String mid) {
		return dao.getTelNo(mid);
	}
	
}
