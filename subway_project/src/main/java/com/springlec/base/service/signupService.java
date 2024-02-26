package com.springlec.base.service;

public interface signupService {
	
	public void signup(String mid, String mpw, String mname, String maddress, String mtel, String mbirth, String memail)
			throws Exception;
	public int checkId(String mid) throws Exception;
	public int checkEmail(String memail) throws Exception;
}
