package com.springlec.base.dao;

public interface SignupDao {

	// 회원 정보를 삽입
	public void signup(String mid, String mpw, String mname, String maddress, String mtel, String mbirth, String memail)
			throws Exception;

	// 아이디 중복체크
	public int checkId(String mid) throws Exception;

	// 이메일 중복체크
	public int checkEmail(String memail) throws Exception;

	// 로그인시 입력한 아이디와 비밀번호가 일치하는지 확인
	public String checkPw(String mid) throws Exception;

	// 이름, 생일, 이메일을 가진 회원 정보가 있는지 확인
	public int checkIdInfo(String mname, String mbirth, String memail) throws Exception;

	// 회원에게 찾은 아이디를 전송
	public String sendId(String mname, String mbirth, String memail) throws Exception;

	// 아이디, 이름, 생일, 이메일을 가진 회원 정보가 있는지 확인
	public int checkPwInfo(String mid, String mname, String mbirth, String memail) throws Exception;

	// 회원에게 찾은 아이디를 전송
	public String sendPw(String mid, String mname, String mbirth, String memail) throws Exception;
	
	// 탈퇴한 아이디인지 확인
	public int deleteIdCheck(String mid) throws Exception;

}
