package com.springlec.base.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springlec.base.dao.Default_Dao;
import com.springlec.base.model.Default_Dto;

@Service
public class Default_Service_Impl implements Default_Service {

	@Autowired
	Default_Dao dao;
	
	@Override
	public List<Default_Dto> default_test() throws Exception {
		// TODO Auto-generated method stub
		return dao.default_test();
	}

}
