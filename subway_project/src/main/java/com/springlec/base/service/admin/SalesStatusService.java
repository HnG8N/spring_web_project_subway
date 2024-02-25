package com.springlec.base.service.admin;

import java.util.List;

import com.springlec.base.model.admin.SalesStatusDto;

public interface SalesStatusService {
	
	public List<SalesStatusDto> monthlySalesChartDataTask() throws Exception;

}
