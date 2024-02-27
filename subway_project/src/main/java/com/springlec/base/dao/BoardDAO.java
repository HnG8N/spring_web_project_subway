package com.springlec.base.dao;

import java.util.List;


import com.springlec.base.model.BoardDTO;

public interface BoardDAO {

	public List<BoardDTO> blistDao() throws Exception;

	public void writeDao(String bmID, String boTitle, String boContent) throws Exception; 

	public BoardDTO viewDao(String boardID) throws Exception;
	
	public void updateDao(String boardID, String boTitle, String boContent) throws Exception;
	
	public void deleteMDao(String boardID) throws Exception;
	
	public List<BoardDTO> listQuery(String query, String content) throws Exception;
	
}
