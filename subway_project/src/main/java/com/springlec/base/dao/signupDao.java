package com.springlec.base.dao;

public interface signupDao {

	public void signup(String mid, String mpw, String mname, String maddress, String mtel, String mbirth, String memail)
			throws Exception;
	public int checkId(String mid) throws Exception;
	public String checkPw(String mid) throws Exception;
	public int checkEmail(String memail) throws Exception;
}
