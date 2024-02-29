package com.springlec.base.service.admin;

import java.util.HashMap;
import java.util.List;

import com.springlec.base.model.admin.MemberInformationDto;
import com.springlec.base.model.admin.SalesStatusDto;

public interface SalesStatusService {
	
	public List<SalesStatusDto> salesChartDataTask(
			String chart, String startDay, String endDay) throws Exception;
	
	public List<MemberInformationDto> memberInfoList(String userInfo) throws Exception;
	
	public HashMap<Object, Object> monthlyBarChart() throws Exception;
	
}
