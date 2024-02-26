package com.springlec.base.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springlec.base.dao.signupDao;

@Service
public class signupServiceImpl implements signupService {

	@Autowired
	signupDao dao;
	
	@Override
	public void signup(String mid, String mpw, String mname, String maddress, String mtel, String mbirth, String memail)
			throws Exception {
		dao.signup(mid, mpw, mname, maddress, mtel, mbirth, memail);
		
	}

	@Override
	public int checkId(String mid) throws Exception {
		// TODO Auto-generated method stub
		return dao.checkId(mid);
	}

	@Override
	public int checkEmail(String memail) throws Exception {
		// TODO Auto-generated method stub
		return dao.checkEmail(memail);
	}

}
