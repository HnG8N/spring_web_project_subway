package com.springlec.base.service.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springlec.base.dao.admin.AdminDao;
import com.springlec.base.model.admin.MemberInformationDto;
import com.springlec.base.model.admin.SalesStatusDto;

@Service
public class SalesStatusServiceImpl implements SalesStatusService {

	@Autowired
	AdminDao dao;
	
	@Override
	public List<SalesStatusDto> salesChartDataTask(
			String chart, String startDay, String endDay) throws Exception {
		
		List<SalesStatusDto> chartData = null;
		
		switch(chart) {
			case ("monthlyBarChart") :
				chartData = dao.monthlySalesChartData();
			break;
			case ("dailyLineChart") :
				chartData = dao.daySalesChartData(startDay, endDay);
			break;
			case ("menuPieChart") :
				chartData = dao.menuCountChartData(startDay, endDay);
			break;
			default :
			break;
		}
		
		return chartData;
	}

	@Override
	public List<MemberInformationDto> memberInfoList() throws Exception {
		return dao.memberInfoList();
	}

}
