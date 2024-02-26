package com.springlec.base.dao;

import com.springlec.base.model.SignupDto;

public interface MypageDao {
	
	public SignupDto memberDto (String mid) throws Exception;
	public void deleteInfo (String mid) throws Exception;
	public void updateInfo (String mid,String mpw, String maddress) throws Exception;

}
