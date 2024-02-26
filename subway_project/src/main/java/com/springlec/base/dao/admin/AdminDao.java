package com.springlec.base.dao.admin;

import java.util.List;

import com.springlec.base.model.admin.LoginVerification_Dto;
import com.springlec.base.model.admin.ProductCrudDto;
import com.springlec.base.model.admin.SalesStatusDto;

public interface AdminDao {
	
	public LoginVerification_Dto loginVerification(String mid) throws Exception;
	
	// ******************************** Product ********************************
	
	// productInsertDB TASK *********************************************************
	public void insertMenuAction(String mnctg, String mnname, String mnengname, 
			String mninfo, String mnimg, String mnprice) throws Exception;
	
	public void insertMenuSpecAction(String mngram, String mnkcal, String mnprotein, 
			String mnfat, String mnsugar, String mnnatrum) throws Exception;
	// ******************************************************************************
	
	// productListCount Task
	public int productListCount(String selectSearch, String search) throws Exception;
	
	// productListSelect Task
	public List<ProductCrudDto> productListSelect(String selectSearch, String search, int limit, int offset) throws Exception;

	// productDetail Task
	public ProductCrudDto productDetail(int mncode) throws Exception;
	
	// ProductUpdateDB Task *********************************************************
	public void updateMenuAction(int mncode, String mnctg, String mnname, 
			String mnengname, String mninfo, String mnprice)
					throws Exception;
	
	public void updateMenuSpecAction(int mncode, String mngram, String mnkcal, 
			String mnprotein, String mnfat, String mnsugar, String mnnatrum)
					throws Exception;
	
	public void updateImgAction(int mncode, String mnimg) throws Exception;
	// ******************************************************************************

	// ****************************** Product End *******************************
	
	
	
	// ****************************** salesStatus *******************************
	// monthlySalesChartData Task
	public List<SalesStatusDto> monthlySalesChartData() throws Exception;
	public List<SalesStatusDto> daySalesChartData(String startDay, String endDay) throws Exception;
	public List<SalesStatusDto> menuCountChartData(String startDay, String endDay) throws Exception;
	
	// **************************** salesStatus End ******************************



}
