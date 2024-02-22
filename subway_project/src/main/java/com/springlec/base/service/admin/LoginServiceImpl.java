package com.springlec.base.service.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springlec.base.dao.admin.AdminDao;
import com.springlec.base.model.admin.LoginVerification_Dto;

@Service
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	AdminDao dao;

	@Override
	public LoginVerification_Dto loginVerificationTask(String mid) throws Exception {
		LoginVerification_Dto loginVerification = dao.loginVerification(mid);
		return loginVerification;
	}

}
