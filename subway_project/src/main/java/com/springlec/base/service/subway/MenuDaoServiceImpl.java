package com.springlec.base.service.subway;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springlec.base.dao.subway.MenuDao;
import com.springlec.base.model.subway.IngredientDto;
import com.springlec.base.model.subway.MenuDto;

@Service
public class MenuDaoServiceImpl implements MenuDaoService {
	@Autowired 
	MenuDao dao;
	
	// 카테고리별 메뉴리스트 가져오기.
	@Override
	public List<MenuDto> getMenuList(String mnctg) {
		// TODO Auto-generated method stub
		return dao.getMenuList(mnctg);
	}

	// 메뉴 상세페이지.
	@Override
	public MenuDto getMenuDetail(int mncode) {
		// TODO Auto-generated method stub
		return dao.getMenuDetail(mncode);
	}

	// 온라인주문시 재료 선택지 가져오기.
	@Override
	public List<IngredientDto> getIngredient(String ctg) {
		// TODO Auto-generated method stub
		return dao.getIngredient(ctg);
	}

}
