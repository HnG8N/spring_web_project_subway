package com.springlec.base.service.admin;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springlec.base.dao.admin.AdminDao;
import com.springlec.base.model.admin.SalesStatusDto;

@Service
public class SalesStatusServiceImpl implements SalesStatusService {

	@Autowired
	AdminDao dao;
	
	@Override
	public List<SalesStatusDto> salesChartDataTask(
			String startDay, String endDay) throws Exception {
		
		List<SalesStatusDto> chartData = null;
		
		Optional<String> optStartDay = Optional.ofNullable(startDay);
		Optional<String> optEndDay = Optional.ofNullable(endDay);
		
		if(optStartDay.isPresent() && optEndDay.isPresent()) {
			chartData = dao.daySalesChartData(startDay, endDay);
		}else {
			chartData = dao.monthlySalesChartData();
		}
		
		return chartData;
	}

}
