package com.springlec.base.service.admin;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.springlec.base.model.admin.ProductCrudDto;

public interface ProductCrudService {
	
	public void ProductInsertTask(MultipartFile file, String mnctg, String mnname, String mnengname, 
			String mninfo, String mnprice, 
			String mngram, String mnkcal, String mnprotein, 
			String mnfat, String mnsugar, String mnnatrum) throws Exception;
	
	public List<ProductCrudDto> productListSelectTask() throws Exception;

	public List<ProductCrudDto> productListSearchTask(
			String selectSearch, String search) throws Exception;


}
