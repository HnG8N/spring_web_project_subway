package com.springlec.base.service.subway;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springlec.base.dao.subway.MenuDao;
import com.springlec.base.model.subway.MenuDto;

@Service
public class MenuDaoServiceImpl implements MenuDaoService {
	@Autowired 
	MenuDao dao;
	
	
	@Override
	public List<MenuDto> getMenuList(String mnctg) {
		// TODO Auto-generated method stub
		return dao.getMenuList(mnctg);
	}

	@Override
	public MenuDto getMenuDetail(int mncode) {
		// TODO Auto-generated method stub
		return dao.getMenuDetail(mncode);
	}

}
