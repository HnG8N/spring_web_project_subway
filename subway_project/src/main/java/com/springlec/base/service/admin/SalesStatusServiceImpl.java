package com.springlec.base.service.admin;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Maps;
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
	public List<MemberInformationDto> memberInfoList(String userInfo) throws Exception {
		List<MemberInformationDto> memberDao = null;
		if(userInfo == null) {
			memberDao = dao.memberInfoList();
		}else {
			switch(userInfo) {
			case("endUser"):
				memberDao = dao.memberEndUser();
			break;
			case("regDate"):
				memberDao = dao.memberRegDate();
			break;
			default:
				break;
			}
		}
		return memberDao;
	}

	@Override
	public HashMap<Object, Object> monthlyBarChart() throws Exception {
		
		HashMap<Object, Object> map = Maps.newHashMap();
		
		List<SalesStatusDto> thisDto = dao.monthlySalesChartData();
		List<SalesStatusDto> preDto = dao.previousSalesChartData();
		
		map.put("this", thisDto);
		map.put("pre", preDto);

		return map;
	}

}
