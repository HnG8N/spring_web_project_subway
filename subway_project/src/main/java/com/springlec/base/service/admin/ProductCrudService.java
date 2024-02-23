package com.springlec.base.service.admin;

import org.springframework.web.multipart.MultipartFile;

public interface ProductCrudService {
	
	public void ProductInsertTask(MultipartFile file, String mnctg, String mnname, String mnengname, 
			String mninfo, String mnprice, 
			String mngram, String mnkcal, String mnprotein, 
			String mnfat, String mnsugar, String mnnatrum) throws Exception;

}
