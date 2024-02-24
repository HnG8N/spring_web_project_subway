package com.springlec.base.dao.admin;

import java.util.List;

import com.springlec.base.model.admin.LoginVerification_Dto;
import com.springlec.base.model.admin.ProductCrudDto;

public interface AdminDao {
	
	public LoginVerification_Dto loginVerification(String mid) throws Exception;
	
	// ProductInsertDB TASK *********************************************************
	public void insertMenuAction(String mnctg, String mnname, String mnengname, 
			String mninfo, String mnimg, String mnprice) throws Exception;
	
	public void insertMenuSpecAction(String mngram, String mnkcal, String mnprotein, 
			String mnfat, String mnsugar, String mnnatrum) throws Exception;
	// ******************************************************************************
	
	// ProductListSelect Task
	public List<ProductCrudDto> productListSelect() throws Exception;


}
