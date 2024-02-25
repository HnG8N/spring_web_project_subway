package com.springlec.base.service.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springlec.base.dao.admin.AdminDao;
import com.springlec.base.model.admin.SalesStatusDto;

@Service
public class SalesStatusServiceImpl implements SalesStatusService {

	@Autowired
	AdminDao dao;
	
	@Override
	public List<SalesStatusDto> monthlySalesChartDataTask() throws Exception {
		return dao.monthlySalesChartData();
	}

}
