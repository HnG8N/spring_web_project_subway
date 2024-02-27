package com.springlec.base.dao.subway;

import java.util.List;

import com.springlec.base.model.subway.OrderDto;

public interface OrderDao {
	public int addOrder(int cseq, String cmid);
	public int deleteCartItem(int cseq, String cmid);
	public String getOrderNumber();
	public List<OrderDto> getMyOrder(String mid);
	public String getTelNo(String mid);
}
