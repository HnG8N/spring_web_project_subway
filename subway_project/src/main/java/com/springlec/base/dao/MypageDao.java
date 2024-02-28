package com.springlec.base.dao;

import com.springlec.base.model.SignupDto;

public interface MypageDao {
	
	// 로그인 된 회원의 정보를 불러오기 위함
	public SignupDto memberDto (String mid) throws Exception;
	
	// 로그인 된 회원의 탈퇴날짜를 update하기 위함
	public void deleteInfo (String mid) throws Exception;
	
	// 로그인 된 회원의 비밀번호와 주소 정보를 업데이트 하기 위함
	public void updateInfo (String mid,String mpw, String maddress) throws Exception;

}
