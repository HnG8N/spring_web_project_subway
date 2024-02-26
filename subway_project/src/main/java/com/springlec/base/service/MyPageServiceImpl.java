package com.springlec.base.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springlec.base.dao.MypageDao;
import com.springlec.base.model.SignupDto;

@Service
public class MyPageServiceImpl implements MyPageService {
	
	@Autowired
	MypageDao dao;
	
	@Override
	public SignupDto memberDto(String mid) throws Exception {
		// TODO Auto-generated method stub
		return dao.memberDto(mid);
	}

	@Override
	public void deleteInfo(String mid) throws Exception {
		dao.deleteInfo(mid);
		
	}

	@Override
	public void updateInfo(String mid, String mpw, String maddress) throws Exception {
		dao.updateInfo(mid, mpw, maddress);
		
	}

}
