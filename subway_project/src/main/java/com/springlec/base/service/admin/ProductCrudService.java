package com.springlec.base.service.admin;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.springlec.base.model.admin.ProductCrudDto;

public interface ProductCrudService {
	
	public void ProductInsertTask(MultipartFile file, String mnctg, String mnname, String mnengname, 
			String mninfo, String mnprice, 
			String mngram, String mnkcal, String mnprotein, 
			String mnfat, String mnsugar, String mnnatrum) throws Exception;
	
	public int ProductListCountTask(String selectSearch, String search) throws Exception;
	
	public List<ProductCrudDto> productListSelectTask(
			String selectSearch, String search, int limit, int offset) throws Exception;

	public ProductCrudDto productDetailTask(int mncode) throws Exception;

	public void ProductUpdateTask(MultipartFile file, int mncode, String mnctg, String mnname, String mnengname, 
			String mninfo, String mnprice, 
			String mngram, String mnkcal, String mnprotein, 
			String mnfat, String mnsugar, String mnnatrum) throws Exception;
}
