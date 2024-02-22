package com.springlec.base.dao.admin;

import com.springlec.base.model.admin.LoginVerification_Dto;

public interface AdminDao {
	
	public LoginVerification_Dto loginVerification(String mid) throws Exception;

}
