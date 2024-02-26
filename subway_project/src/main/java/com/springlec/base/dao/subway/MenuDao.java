package com.springlec.base.dao.subway;

import java.util.List;

import com.springlec.base.model.subway.MenuDto;

public interface MenuDao {
	// 카테고리별 메뉴리스트 가져오기.
	public List<MenuDto> getMenuList(String mnctg);
	
	// 메뉴 상세페이지.
	public MenuDto getMenuDetail(int mncode);
}
