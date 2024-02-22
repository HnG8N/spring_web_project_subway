package com.springlec.base.service.admin;

import com.springlec.base.model.admin.LoginVerification_Dto;

public interface LoginService {
	
	public LoginVerification_Dto loginVerificationTask(String mid) throws Exception;

}
