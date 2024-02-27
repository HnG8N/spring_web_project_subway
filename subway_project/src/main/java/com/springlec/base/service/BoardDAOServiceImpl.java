package com.springlec.base.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springlec.base.dao.BoardDAO;
import com.springlec.base.model.BoardDTO;

@Service
public class BoardDAOServiceImpl implements BoardDAOService {
	
	@Autowired
	BoardDAO dao;
	
	@Override
	public List<BoardDTO> blistDao() throws Exception {
		// TODO Auto-generated method stub
		return dao.blistDao();
	}

	@Override
	public void writeDao(String bmID, String boTitle, String boContent) throws Exception {
		// TODO Auto-generated method stub
		dao.writeDao(bmID, boTitle, boContent);
		
	}

	@Override
	public BoardDTO viewDao(String boardID) throws Exception {
		// TODO Auto-generated method stub
		return dao.viewDao(boardID);
	}

	@Override
	public void updateDao(String boardID, String boTitle, String boContent) throws Exception {
		// TODO Auto-generated method stub
		dao.updateDao(boardID, boTitle, boContent);
		
	}

	@Override
	public void deleteMDao(String boardID) throws Exception {
		// TODO Auto-generated method stub
		dao.deleteMDao(boardID);
	}

	@Override
	public List<BoardDTO> listQuery(String query, String content) throws Exception {
		// TODO Auto-generated method stub
		// 쿼리문에 like를 사용하기 위해서. 위의 ADto 바꿔줌.
		content ='%'+content+'%';	
		return dao.listQuery(query, content);
	}


	
	
	

}
