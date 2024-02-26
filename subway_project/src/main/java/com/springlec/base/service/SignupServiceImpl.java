package com.springlec.base.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springlec.base.dao.SignupDao;

@Service
public class SignupServiceImpl implements SignupService {

	@Autowired
	SignupDao dao;
	
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

	@Override
	public String checkPw(String mid) throws Exception {
		// TODO Auto-generated method stub
		return dao.checkPw(mid);
	}

	@Override
	public int checkIdInfo(String mname, String mbirth, String memail) throws Exception {
		// TODO Auto-generated method stub
		return dao.checkIdInfo(mname, mbirth, memail);
	}

	@Override
	public String sendId(String mname, String mbirth, String memail) throws Exception {
		// TODO Auto-generated method stub
		return dao.sendId(mname, mbirth, memail);
	}

	@Override
	public int checkPwInfo(String mid, String mname, String mbirth, String memail) throws Exception {
		// TODO Auto-generated method stub
		return dao.checkPwInfo(mid, mname, mbirth, memail);
	}

	@Override
	public String sendPw(String mid, String mname, String mbirth, String memail) throws Exception {
		// TODO Auto-generated method stub
		return dao.sendPw(mid, mname, mbirth, memail);
	}

}
